package com.tonyzhai.leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * 1. You may assume that the array does not change.
 * 2. There are many calls to sumRange function.
 */
public class LC303 {

    int[] sums = null;

    /**
     * DP
     * [-2, 0, 3, -5, 2, -1]
     *
     *
     * sums[0] = 0;
     * sums[1] = -2;
     * sums[2] = -2;
     * sums[3] = 1;
     * sums[4] = -4;
     * sums[5] = -2;
     * sums[6] = -3;
     *
     * (0, 2) = sums[3] - sums[0] = 1;
     * (2, 5) = sums[6] - sums[2] = -1;
     *
     * @param nums
     */
    public LC303(int[] nums) {
        if (nums != null && nums.length != 0) {
            sums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null) {
            return 0;
        }
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        LC303 obj = new LC303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
