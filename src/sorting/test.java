package sorting;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int[] a={1,2,3};
		test atest=new test();
		atest.tozero(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void change(int[] a){
		a[0]=0;
		a[1]=0;
		
	}
	
	public void tozero(int[] a){
		a[0]=0;
		a[1]=0;
		a[2]=2;
	}

}
