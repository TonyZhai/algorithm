package com.tonyzhai.algorithm;

/**
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *
 * 螺旋打印结果：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *
 * 解题思路：1的坐标为[0][0], 16的坐标为[3][3], 打印左上角[0][0]到右下角[3][3]一圈，向內缩继续打印[1][1]到[2][2]
 * 直到左上<=右下
 *
 */
public class                            HelicalPrint {

    public static void print(int[][] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int row = input.length;
        int column = input[0].length;
        int startX = 0;
        int startY = 0;
        int endX = row - 1;
        int endY = column - 1;
        while (startX <= endX && startY <= endY) {
            printCycle(input, startX++, startY++, endX--, endY--);
        }
    }

    private static void printCycle(int[][] input, int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endY; i++) {
            System.out.println(input[startX][i]);
        }

        for (int i = startX + 1; i <= endX; i++) {
            System.out.println(input[i][endY]);
        }

        if (startX != endX) {
            for (int i = endY - 1; i >= startY; i--) {
                System.out.println(input[endX][i]);
            }
        }

        if (startY != endY) {
            for (int i = endX - 1; i > startX; i--) {
                System.out.println(input[i][startX]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]
                {
                        {1, 2, 3, 4}
//                        {5, 4, 6, 8},
//                        {9, 10, 11, 12},
//                        {13, 14, 15, 16}
//                        {22,23,24},
//                        {25,62,61}
                };
        print(input);
    }
}
