package com.tonyzhai.algorithm.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class LC62 {

    /**
     * DP, m行n列, i = m - 1, j = n - 1
     * 要么往右走要么往下走，如果从右下角finish上方dp[i - 1][j]和左方dp[i][j - 1]来看都是一步，那么
     * base是 dp[i - 1][j] = 1, dp[i][j - 1] = 1
     * dp[i][j]代表从这个点走到finish有多少唯一路径
     * dp[i][j] = dp[i][j + 1] + dp[i + 1][j]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        if (m > 1 && n > 0) {
            dp[m - 2][n - 1] = 1;
        }
        if (m > 0 && n > 1) {
            dp[m - 1][n - 2] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(dp[i][j] != 0) {
                    continue;
                }
                dp[i][j] = (j + 1 < n ? dp[i][j + 1] : 0) + (i + 1 < m ? dp[i + 1][j] : 0);
            }
        }
        return dp[0][0];
    }


    /**
     * DP, m行n列, i = m - 1, j = n - 1
     * 要么往右走要么往下走，如果从右下角finish上方dp[i - 1][j]和左方dp[i][j - 1]来看都是一步，那么
     * base是 最下边一行和最右边一列的dp值都是1，因为最下边一行只能往右走，只有一种走法，最右边只能往下走也就一种走法
     * dp[i][j]代表从这个点走到finish有多少唯一路径，从下走的路径和+从右走的路径和
     * dp[i][j] = dp[i][j + 1] + dp[i + 1][j]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(1,10));
    }
}
