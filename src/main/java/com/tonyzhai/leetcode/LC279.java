package com.tonyzhai.leetcode;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class LC279 {

    /**
     * DP
     * dp[i]代表当前数字最少需要的平方数字个数
     * dp[0] = 0;
     * dp[i] = min(dp[i], dp[i - j*j] + 1)
     *
     *
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 先给dp[i]一个最大值，最大值就是自己，例如4，最大个数就是1+1+1+1，即自己的值
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 然后循环找到那个最合适的j，即是平方数最小数量
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
