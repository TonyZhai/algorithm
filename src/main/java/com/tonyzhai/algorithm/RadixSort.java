package com.tonyzhai.algorithm;

import java.util.Arrays;

/**
 * @author tony
 *
 */
public class RadixSort {
	public static void sort(int[] array){
		int maxLength = String.valueOf(array[0]).length();
		int minNagetive = 0;
		for(int i = 1; i < array.length; i++){
			if(array[i] < 0 && array[i] < minNagetive){
				minNagetive = array[i];
			}
			int length = String.valueOf(array[i]).length();
			maxLength = Math.max(maxLength, length);
		}
		if(minNagetive != 0){
			for(int i = 0; i < array.length; i++){
				array[i] += Math.abs(minNagetive);
			}
		}
		sort(array, 10, maxLength);
		if(minNagetive != 0){
			for(int i = 0; i < array.length; i++){
				array[i] += minNagetive;
			}
		}
	}

	public static void sort(int[] array, int radix, int maxValueLength){
		int[] temp = new int[array.length];
		int[] count = new int[radix];

		int rate = 1;

		for(int i = 0; i < maxValueLength; i++){
			Arrays.fill(count, 0);
			System.arraycopy(array, 0, temp, 0, array.length);

			for(int j = 0; j < array.length; j++){
				int tempKey = (temp[j] / rate) % radix;
				count[tempKey]++;
			}

			for(int j = 1; j < radix; j++){
				count[j] = count[j] + count[j - 1];
			}

			for(int j = array.length - 1; j >= 0; j--){
				int tempKey = (temp[j] / rate) % radix;
				array[count[tempKey] - 1] = temp[j];
				count[tempKey]--;
			}

			rate *= radix;
		}
	}

	public static void main(String[] args){
		int[] array = {0, 3, 2, -11, -312};
		sort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}
