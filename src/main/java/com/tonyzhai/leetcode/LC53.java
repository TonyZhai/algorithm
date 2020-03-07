package com.tonyzhai.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and
 * conquer approach, which is more subtle.
 */
public class LC53 {

    /**
     * DP
     * max选择或者不选择
     * dp[i]表示下标在i的时候的最大值
     * dp[i] = max(dp[i - 1] + i, dp[i])
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LC53().maxSubArray(new int[]{-2,1}));
    }
}
