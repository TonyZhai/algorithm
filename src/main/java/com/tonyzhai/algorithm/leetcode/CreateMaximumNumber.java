package com.tonyzhai.algorithm.leetcode;

/**
 Example 1:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]

 Example 2:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 return [6, 7, 6, 0, 4]

 Example 3:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 return [9, 8, 9]
 */
public class CreateMaximumNumber {

    /**
     * divide k to i and k - i, then find every merge result, last find the largest one
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int nums1Length = nums1.length;
        for(int i = Math.max(0, k - nums2.length); i <= k && i <= nums1Length; i++){
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if(greater(temp, 0, result, 0)){
                result = temp;
            }
        }
        return result;
    }

    /**
     * find maximum k elements in an array, the relative order of the new array from the same array must be preserved
     *
     * @param array
     * @param k
     * @return
     */
    private int[] maxArray(int[] array, int k){
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        int i = 0; //result array index
        int length = array.length;
        for(int j = 0; j < length; j++){
            while(length - j + i > k && i > 0 && result[i - 1] < array[j]){
                i--;
            }
            if(i < k) {
                result[i++] = array[j];
            }
        }
        return result;
    }

    /**
     * merge k number elements of two array, the relative order of the new array from the same array must be preserved
     *
     * @param array1
     * @param array2
     * @param k
     * @return
     */
    private int[] merge(int[] array1, int[] array2, int k){
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        int i = 0, j = 0;
        for(int l = 0; l < k; l++){
            result[l] = greater(array1, i, array2, j) ? array1[i++] : array2[j++];
        }
        return result;
    }

    /**
     *
     *
     * @param array1
     * @param i
     * @param array2
     * @param j
     * @return
     */
    private boolean greater(int[] array1, int i, int[] array2, int j) {
        while(i < array1.length && j < array2.length && array1[i] == array2[j]){
            i++;
            j++;
        }
        return j == array2.length || (i < array1.length && array1[i] > array2[j]);
    }
}
