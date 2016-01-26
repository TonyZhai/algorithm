package com.tonyzhai.algorithm;

/**
 * ?????3
 * 		????????method1??????method2???????????method3????O(n)???
 *
 * @author tony
 */
public class FindMaximumSubArray {

    /**
     * @param array
     * @return
     */
    public static int method1(int[] array){
        int maxSum = -Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = 0;
            for(int j = i; j < array.length; j++){
                sum += array[j];
                if(maxSum < sum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int method2(int[] array, int low, int high){
        if(low == high){
            return array[low];
        }
        int mid = (low + high) / 2;
        int maxLeft = method2(array, low, mid);
        int maxRight = method2(array, mid + 1, high);

        int leftSum = 0;
        int leftMaxSum = -Integer.MAX_VALUE;
        for(int i = mid; i >= low; i--){
            leftSum+=array[i];
            if(leftMaxSum < leftSum){
                leftMaxSum = leftSum;
            }
        }

        int rightSum = 0;
        int rightMaxSum = -Integer.MAX_VALUE;
        for(int i = mid + 1; i <= high; i++){
            rightSum+=array[i];
            if(rightMaxSum < rightSum){
                rightMaxSum = rightSum;
            }
        }

        if(maxLeft >= maxRight){
            return Math.max(maxLeft, leftMaxSum + rightMaxSum);
        }else{
            return Math.max(maxRight, leftMaxSum + rightMaxSum);
        }
    }

    /**
     * @param array
     * @return
     */
    public static int method3(int[] array){
        int maxSum = -Integer.MAX_VALUE;
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
        System.out.println(method1(array));
        System.out.println(method2(array, 0, array.length - 1));
        System.out.println(method3(array));
    }
}