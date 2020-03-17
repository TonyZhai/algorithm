package com.tonyzhai.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class LC63 {

    /**
     * DP
     * if obstacleGrid[i][j] == 1,
     * dp[i][j] = 0
     * else
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        dp[rows - 1][columns - 1] = 1;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                if (i == rows - 1 && j == columns - 1) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    } else {
                        continue;
                    }
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }

            }
        }
        return dp[0][0];
    }

    /**
     * DP
     * 用一维数组
     * dp[j] = dp[j] + dp[j + 1]
     *
     * 000
     * 010
     * 000
     *
     * 从右下角开始，右下角 0 -> dp[2] = 1
     * 然后从最后一行从右往左迭代
     * dp[1] = dp[1] + dp[2] = 1;
     * dp[0] = dp[0] + dp[1] = 1;
     *
     * 这时候最后一行的dp值为
     * 111 （i为2即第三行的结果）
     *
     * 然后循环中间那行从右往左 (只有 j < cols - 1 即 < 2)
     * so
     * dp[2]还是1
     * dp[1] = dp[1] + dp[2] = 2, 仔细理解这个等式 equals dp[i][j] = dp[i + 1][j] + dp[i][j + 1], 当前i=1，i+1=2
     * 当前dp[1]存的就是dp[2][1]的值，即它上一次循环的第三行的那个j，所以这个时候dp[j]就是dp[i + ][j],同理dp[j + 1]就是
     * dp[i][j + 1]
     *
     * ...
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[cols - 1] = 1;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j < cols - 1) {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new LC63().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
}
