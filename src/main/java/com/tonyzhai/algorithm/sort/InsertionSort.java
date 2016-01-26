package com.tonyzhai.algorithm.sort;

public class InsertionSort {
	public static void sort(int[] array){
		for(int i = 1; i < array.length; i++){
			int current = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > current){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}

	public static void main(String[] args){
		int[] array = {29, 11, 100, 109, 0, 1, 111};
		sort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}
