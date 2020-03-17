package com.tonyzhai.leetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class LC213 {

    /**
     * DP
     * 0 ~ n -1
     * 1 ~ n
     * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max1 = 0;
        int max2 = 0;
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 从第一个偷到倒数第一个，因为最后一个和第一个相邻
        int[] dp1 = new int[len + 1];
        dp1[1] = nums[0];
        // 从第二个偷到最后一个
        int[] dp2 = new int[len + 1];
        dp2[2] = nums[1];

        // 2 ~ n - 1
        for (int i = 2; i <= len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
            max1 = Math.max(max1, dp1[i]);
        }

        // 3 ~ n
        for (int i = 3; i <= len; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
            max2 = Math.max(max2, dp2[i]);
        }

        return Math.max(max1, max2);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 从第一个偷到倒数第一个，因为最后一个和第一个相邻
        int[] dp1 = new int[len + 1];
        dp1[1] = nums[0];
        // 从第二个偷到最后一个
        int[] dp2 = new int[len + 1];

        // 2 ~ n
        for (int i = 2; i <= len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }

        return Math.max(dp1[len - 1], dp2[len]);
    }

    public static void main(String[] args) {
        System.out.println(new LC213().rob(new int[]{1, 1}));
    }
}
