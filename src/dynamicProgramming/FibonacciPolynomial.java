package dynamicProgramming;

import java.util.Scanner;

/**
 * 裴波那切数列
 * @author YR
 *
 */
public class FibonacciPolynomial {

	public static void main(String[] args) {
		Scanner reader =new Scanner(System.in);
		while(reader.hasNextInt()){
			int n=reader.nextInt();
			System.out.println(fibo(n));
		}

	}
	/**
	 * 递归解
	 * @param n
	 */
	public static int fib(int n){
		
		if(n==0||n==1){
			return n;
		}
		return fib(n-1)+fib(n-2);
	}
	/**
	 * 非递归解
	 * @param n
	 * @return
	 */
	public static int fibo(int n){
		int[] f=new int[n+1];
		if (n==1||n==0) {
			return n;
		}
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=n;i++){
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}
	
	
	

}
