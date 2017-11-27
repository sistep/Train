package sorting;

import java.util.Stack;

public class SortUnits {

	public static void main(String[] args) {
		int[] a = { 5, 6, 3, 1, 8, 7, 2, 4 };
		mergeSort(a,0,a.length-1);
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		

	}
	
	/**
	 * 归并排序
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			//左边
			mergeSort(a, low, mid);
			//右边
			mergeSort(a, mid + 1, high);
			//有序序列归并
			merge(a, low, mid, high);
		}
	}
	/**
	 * 归并。合并两个数组。
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		// 左指针
		int i = low;
		// 右指针
		int j = mid + 1;
		// 临时数组指针
		int k = 0;
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		//左边剩余
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		//右边剩余
		while (j <= high) {
			temp[k++] = a[j++];
		}
		// 倒出
		for (int t = 0; t < temp.length; t++) {
			a[t + low] = temp[t];
		}
	}
	
	/**
	 * 冒泡排序
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		if (null == a || a.length < 2) {
			return;
		}
		boolean flag;
		for (int i = 0; i < a.length - 1; i++) {
			flag = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = true;
				}
				
			}
			if (flag == false) {
				return;
			}
		}
	}

	/**
	 * 选择排序
	 * @param A
	 * @param n
	 * @return
	 */
	public static int[] selectionSort(int[] A, int n) {
		// write code here
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i; j < n; j++) {
				if (A[j] <= A[min]) {
					min = j;
				}
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
		return A;
	}

	

	/**
	 * 冒泡排序
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static int[] bubbleSort(int[] A, int n) {
		// write code here
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (A[j] > A[j + 1]) {
					int temp = A[j + 1];
					A[j + 1] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}

	/**
	 * 希尔排序 最优复杂度O(n),平均复杂度跟步长选取有关 不稳定
	 * 
	 * @param a
	 * @return
	 */
	public static int[] shellShorting(int[] a) {
		int n = a.length;
		int h = 0;
		while (h <= n) // 生成初始增量
		{
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				int j = i - h;
				int get = a[i];
				while (j >= 0 && a[j] > get) {
					a[j + h] = a[j];
					j = j - h;
				}
				a[j + h] = get;
			}
			h = (h - 1) / 3; // 递减增量
		}
		return a;
	}

	/**
	 * 插入排序。 时间复杂度O（n^2),空间复杂度O（1），稳定 升序。
	 * 
	 * @param a
	 * @return
	 */
	public static int[] insertionSorting(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int n = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > n) {// 升序。改为a[j]<n则为降序
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = n;
		}
		return a;
	}

}
