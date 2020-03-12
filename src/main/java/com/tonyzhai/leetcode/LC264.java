package com.tonyzhai.leetcode;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class LC264 {

    /**
     * 1*2 2*2 2*3 2*4 2*5 ...
     * 1*3 2*3 3*3 4*3 5*3 ...
     * 1*5 2*5 3*5 4*5 5*5 ...
     *
     * 三行归并排序
     * 1*2, 1*3, 2*2, 1*5 ...
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            arr[i] = min;
            if (factor2 == min) {
                factor2 = 2 * arr[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * arr[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * arr[++index5];
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        new LC264().nthUglyNumber(10);
    }
}
