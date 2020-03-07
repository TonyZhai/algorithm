package com.tonyzhai.practise.date20200221;

public class HelicalPrint {

    public static void print(int[][] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int startX = 0;
        int startY = 0;
        int endX = input.length - 1;
        int endY = input[0].length - 1;

        while (startX <= endX && startY <= endY) {
            printCycle(input, startX++, startY++, endX--, endY--);
        }
    }

    public static void printCycle(int[][] input, int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endY; i++) {
            System.out.println(input[startX][i]);
        }

        for (int i = startX + 1; i <= endX; i++) {
            System.out.println(input[i][endY]);
        }

//        if (startX != endX) {
            for (int i = endY - 1; i >= startX; i--) {
                System.out.println(input[endX][i]);
            }
//        }

//        if (startY != endY) {
            for (int i = endX - 1; i > startX; i--) {
                System.out.println(input[i][startX]);
            }
//        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 4, 6, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
//                        {22,23,24},
//                        {25,62,61}
                };
        //System.out.println(input.length);
        print(input);
    }
}
