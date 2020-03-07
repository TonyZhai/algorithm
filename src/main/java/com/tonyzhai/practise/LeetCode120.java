package com.tonyzhai.practise;

import java.util.List;

/**
 * 从下到上遍历没行的每个元素求出当前元素的最短路径和，因为要么走当前i的下一行也就是
 * i + 1行的j要么走j+1，例如
 *     2
 *    5 7
 *   6 1 3
 *  3 2 9 8
 *
 * 上图从倒数第一行开始循环，拿到6(坐标是dp[2][0]), 检查6的下边一行相邻俩元素3(坐标是db[3],[0])
 * 2(坐标是dp[3][1])，所以推导出从6算起最小路径和是
 * dp[2][0] = dp[2][0] + min(dp[2 + 1][0], dp[2 + 1][0 + 1])
 * =
 * dp[2][0] = 6 + min(3, 2) = 8;
 * 依次类推到顶端2，循环执行一下DP方程
 * dp[i][j] = dp[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
 */
public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);

    }
}
