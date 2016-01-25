package com.tonyzhai.algorithm;

public class MaxSubArray {
	public static int getMaxSubArray1(int[] array) {
		int sum = 0;
		int max = array[0];
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				if (sum > max) {
					max = sum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		System.out.println("start index = " + startIndex);
		System.out.println("end index = " + endIndex);
		return max;
	}

	public static int getMaxSubArray2(int[] array) {
		int max = array[0];
		int sum = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum >= 0) {
				sum += array[i];
			} else {
				sum = array[i];
				startIndex = i;
			}
			if (sum > max) {
				max = sum;
				endIndex = i;
			}
		}
		if(startIndex == array.length - 1){
			startIndex = endIndex;
		}
		System.out.println("start index = " + startIndex);
		System.out.println("end index = " + endIndex);
		return max;
	}

	public static void main(String[] args) {
		int[] origin1 = {1, -3, 9, 31, -29, 39};
		int[] origin2 = {-25, -3, -9, 0, -31, -29, -1, -39};
		int[] origin3 = {1, 3, 20, 12, 11};
		System.out.println(getMaxSubArray1(origin1));
		System.out.println("=====================");
		System.out.println(getMaxSubArray2(origin1));
		System.out.println("=====================");
		System.out.println(getMaxSubArray1(origin2));
		System.out.println("=====================");
		System.out.println(getMaxSubArray2(origin2));
		System.out.println("=====================");
		System.out.println(getMaxSubArray1(origin3));
		System.out.println("=====================");
		System.out.println(getMaxSubArray2(origin3));
	}
}
