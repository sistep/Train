package dynamicProgramming;

public class MinCoin {

	public static void main(String[] args) {
		int coinNum=3; //Ӳ������
		int[] coins=new int[coinNum];//����Ӳ�ҵ���ֵ
		coins[0]=1;
		coins[1]=3;
		coins[2]=5;
		int n=11;//��Ҫ������
		int[][] dp=new int[n+1][2];
		System.out.println(getMinCoinNum(coins, n,dp));
		System.out.println(getMinCoinStr(dp, n).trim());
		

	}
	
	/**
	 * ��coins�չ�n���������Ӳ����
	 * @param coins Ӳ�����
	 * @param n
	 * @param dp ��̬�滮����d[n][0]Ϊ�չ�n���������Ӳ������d[n][1]Ϊ���õ����һ��Ӳ��
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
	 * ��������Ӳ������
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
