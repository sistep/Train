package dynamicProgramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		String seqStr="5 3 4 8 6 7";
		String[] nums=seqStr.split(" ");
		int n=nums.length;
		int[] seq=new int[n];
		int[][] dp=new int[n][2];
		
		for (int i = 0; i < nums.length; i++) {
			seq[i]=Integer.parseInt(nums[i]);
		}
		System.out.println(lis(seq, n, dp));
		System.out.println(lisSeq(seq, dp));

	}
	
	/**
	 * ������ǽ������г���
	 * @param seq ����
	 * @param n ���г���
	 * @param dp ����,dp[i][0]��ʾ��seq[i]��β����ǽ������г��ȣ�dp[i][1]��ʾ����������һ���ַ���seq�е�������
	 * @return
	 */
	public static int lis(int[] seq,int n,int[][] dp){
		dp[0][0]=1;dp[0][1]=0;
		int max=0;
		for(int i=1;i<n;i++){
			int lisLength=1;
			for(int j=0;j<i;j++){
				if(seq[j]<seq[i]){
					int curLength=dp[j][0]+1;
					if(curLength>=lisLength){
						lisLength=curLength;
						dp[i][1]=j;
					}
				}
			}
			dp[i][0]=lisLength;
			if(lisLength==1){
				dp[i][1]=i;
			}
			if(lisLength>=max){
				max=lisLength;
			}
		}
		return max;
	}
	
	/**
	 * ��ȡ��ǽ�������
	 * @param seq
	 * @param dp
	 * @return
	 */
	public static String lisSeq(int[] seq,int[][] dp){
		String line="";
		int max=0;
		int index=-1;
		for(int i=0;i<dp.length;i++){
			if(dp[i][0]>=max){
				index=i;
			}
		}
		int preIndex=dp[index][1];
		line=seq[index]+" "+line;
		while(preIndex!=index){
			index=preIndex;
			preIndex=dp[index][1];
			line=seq[index]+" "+line;
		}
		
		return line;
	}

}
