package com.tonyzhai.algorithm.sort;

public class ShellSort {
    public static void sort(int[] array) {
        int out, in, tmp;
        int len = array.length;
        int h = 1;
        while (h < len / 3)
            h = h * 3 + 1;

        while (h > 0) {
            for (out = h; out < len; out++) {
                tmp = array[out];
                in = out - h;
                while (in >= h - 1 && array[in] > tmp) {
                    array[in + h] = array[in];
                    in -= h;
                }
                array[in + h] = tmp;
                h = (h - 1) / 3;
            }
        }
    }
}