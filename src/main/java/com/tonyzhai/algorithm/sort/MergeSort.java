package com.tonyzhai.algorithm.sort;

/**
 * @author Administrator
 */
public class MergeSort {

	public static void mergeSort(int[] array){
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	private static void merge(int[] array, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] leftArray = new int[n1 + 1];
		int[] rightArray = new int[n2 + 1];
		int i = p;
		int k = 0;
		while(i <= q){
			leftArray[k++] = array[i++];
		}
		int j = q + 1;
		k = 0;
		while(j <= r){
			rightArray[k++] = array[j++];
		}
		leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
		rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		k = p;
		while(k <= r){
			if(leftArray[i] <= rightArray[j]){
				array[k++] = leftArray[i++];
			}else{
				array[k++] = rightArray[j++];
			}
		}
	}

	public static void main(String[] args){
		int[] array = {23, 1, 19, 100, 10};
		mergeSort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}
