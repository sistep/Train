package units;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class KMP {

	public static void main(String[] args) {
		String target="aabbccabc";
		String pattern="cab";
		System.out.println(KMPPatternMatch(target, pattern, 0));

	}
	
	/**
	 * KMP算法
	 * @param target
	 * @param pattern
	 * @param start
	 * @return 找到返回起始位置，否则-1
	 */
	public static int KMPPatternMatch(String target,String pattern,int start){
		if(target==null||pattern==null||pattern.length()==0||pattern.length()>target.length()){
			return -1;
		}
		int i=start,j=0;
		int[] next=getNext(pattern);
		while(i<target.length()){
			if(j==-1||target.charAt(i)==pattern.charAt(j)){
				i++;j++;
			}else{
				j=next[j];
			}
			if(j==pattern.length()){
				return i-j;
			}
		}
		return -1;
	}

	/**
	 * 计算next数组
	 * @param pattern
	 * @return
	 */
	private static int[] getNext(String pattern) {
		int[] next =new int[pattern.length()];
		int j=0,k=-1;
		next[0]=-1;
		while(j<pattern.length()-1){
			if(k==-1||pattern.charAt(k)==pattern.charAt(j)){
				j++;k++;
				if(pattern.charAt(k)==pattern.charAt(j)){
					next[j]=next[k];
				}else{
					next[j]=k;
				}
			}else{
				k=next[k];
			}
		}
		
		return next;
	}

}
