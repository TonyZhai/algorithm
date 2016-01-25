package com.tonyzhai.algorithm;

public class MaxSubArrayPrictise {
	public static int maxSubArray(int[] array){
		int maxSum = -Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		int end = 0;
		for(int i = 0; i < array.length; i++){
			sum = 0;
			for(int j = i; j < array.length; j++){
				sum = sum + array[j];
				if(sum > maxSum){
					start = i;
					end = j;
					maxSum = sum;
				}
			}
		}
		System.out.println("start = " + start);
		System.out.println("end = " + end);
		System.out.println("max = " + maxSum);
		return maxSum;
	}
	
	public static int maxSubArray1(int[] array){
		return maxSubArray1(array, 0, array.length - 1);
	}
	
	private static int maxSubArray1(int[] array, int low, int high) {
		if(low == high){
			return array[low];
		}
		int mid = (low + high) / 2;
		int leftMaxValue = maxSubArray1(array, low, mid);
		int rightMaxValue = maxSubArray1(array, mid + 1, high);
		
		//get cross mid max value
		int maxCrossLeftSum = 0;
		int leftSum = 0;
		for(int i = mid; i >= low; i--){
			leftSum += array[i];
			if(leftSum > maxCrossLeftSum){
				maxCrossLeftSum = leftSum;
			}
		}
		int maxCrossRightSum = 0;
		int rightSum = 0;
		for(int j = mid + 1; j <= high; j++){
			rightSum += array[j];
			if(rightSum > maxCrossRightSum){
				maxCrossRightSum = rightSum;
			}
		}
		if(leftMaxValue >= rightMaxValue){
			return Math.max(leftMaxValue, maxCrossLeftSum + maxCrossRightSum);
		}else{
			return Math.max(rightMaxValue, maxCrossLeftSum + maxCrossRightSum);
		}
	}
	
	public static int maxSubArray2(int[] array){
		int maxSum = 0;
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			if(sum >= 0){
				sum += array[i];
			}else{
				sum = array[i];
			}
			if(sum > maxSum){
				maxSum = sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args){
		int[] array = {-1, 3, -4, 12, -11, 9, 4};
		maxSubArray(array);
		System.out.println(maxSubArray1(array));
		System.out.println(maxSubArray2(array));
	}
}
