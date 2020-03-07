package com.tonyzhai.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ 
 *          [1,3,1], 
 *          [1,5,1], 
 *          [4,2,1] 
 *        ] 
 * Output: 7 Explanation: Because the path
 * 1→3→1→1→1 minimizes the sum.
 * 
 */
class LC64 {

    /**
     * DP
     * 
     * dp[i][j] indicates the current position's minimun sum to bottom-right
     * dp[i][j] = min(dp[i][j] + dp[i][j + 1], dp[i][j] + dp[i + 1][j])
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                } else if (i == m - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = Math.min(grid[i][j] + dp[i][j + 1], grid[i][j] + dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }


    /**
     * DFS back-tracking
     * 
     */
    public int minPathSum1(int[][] grid) {
        return 0;
    }

    /**
     * Brute force
     * 
     */
    public int minPathSum2(int[][] grid) {
        return 0;
    }

    public static void main(String[] args) {
        new LC64().minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } });
    }

}