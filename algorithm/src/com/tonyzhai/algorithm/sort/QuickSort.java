package com.tonyzhai.algorithm.sort;

public class QuickSort {
	public static void sort(int[] array){
		sort(array, 0, array.length - 1);
	}
	
	private static void sort(int[] array, int low, int high){
		if(low < high){
			int mid = getMid(array, low, high);
			sort(array, low, mid - 1);
			sort(array, mid + 1, high);
		}
	}

	private static int getMid(int[] array, int low, int high) {
		int midValue = array[low];
		while(low < high){
			while(low < high && array[high] >= midValue) high--;
			array[low] = array[high];
			while(low < high && array[low] <= midValue) low++;
			array[high] = array[low];
		}
		array[low] = midValue;
		return low;
	}
	
	private static void display(int[] array) {
		for(int data : array){
			System.out.print(data + " ");
		}
	}
	
	public static void main(String[] args){
		int[] array = {1, 5, 4, 22, 12, 129, 99};
		sort(array);
		display(array);
	}
}
