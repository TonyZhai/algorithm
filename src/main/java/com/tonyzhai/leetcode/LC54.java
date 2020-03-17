package com.tonyzhai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int startX = 0;
        int startY = 0;
        int endX = row - 1;
        int endY = column - 1;
        while (startX <= endX && startY <= endY) {
            printCycle(matrix, startX++, startY++, endX--, endY--, res);
        }
        return res;
    }

    private void printCycle(int[][] matrix, int startX, int startY, int endX, int endY, List<Integer> res) {
        for (int i = startX; i <= endY; i++) {
            res.add(matrix[startX][i]);
        }

        for (int i = startX + 1; i <= endX; i++) {
            res.add(matrix[i][endY]);
        }

        if (startX != endX) {
            for (int i = endY - 1; i >= startY; i--) {
                res.add(matrix[endX][i]);
            }
        }

        if (startY != endY) {
            for (int i = endX - 1; i > startX; i--) {
                res.add(matrix[i][startX]);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> res = new LC54().spiralOrder(new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 4, 6, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                        {22, 23, 24, 33},
                        {25, 62, 61, 11}
                });
        for (Integer re : res) {

            System.out.println(re);
        }
    }
}
