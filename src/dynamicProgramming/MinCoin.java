package dynamicProgramming;

public class MinCoin {

	public static void main(String[] args) {
		int coinNum=3; //硬币种类
		int[] coins=new int[coinNum];//各个硬币的面值
		coins[0]=1;
		coins[1]=3;
		coins[2]=5;
		int n=11;//需要的总数
		int[][] dp=new int[n+1][2];
		System.out.println(getMinCoinNum(coins, n,dp));
		System.out.println(getMinCoinStr(dp, n).trim());
		

	}
	
	/**
	 * 用coins凑够n所需的最少硬币数
	 * @param coins 硬币面额
	 * @param n
	 * @param dp 动态规划矩阵。d[n][0]为凑够n所需的最少硬币数，d[n][1]为所用的最后一个硬币
	 * @return
	 */
	public static int getMinCoinNum(int[] coins,int n,int[][] dp){
		
		String coinStr="";
		dp[0][0]=0;dp[0][1]=0;
		for(int i=1;i<=n;i++){
			int coinCount=i;
			int curCoin=0;
			for (int coin : coins) {
				if(i-coin>=0){
					int count=dp[i-coin][0]+1;
					if(count<coinCount){
						coinCount=count;
						dp[i][1]=coin;
					}
				}
			}
			dp[i][0]=coinCount;
		}
		return dp[n][0];
		
	}
	/**
	 * 返回所用硬币序列
	 * @param dp
	 * @param n
	 * @return
	 */
	public static String getMinCoinStr(int[][] dp,int n){
		String line="";
		int curCoin=dp[n][1];
		while(curCoin>0){
			line=curCoin+" "+line;
			n=n-curCoin;
			curCoin=dp[n][1];
		}
		return line;
	}

}
