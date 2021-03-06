package com.tonyzhai.practise.one;

/**
 * Add some description
 *
 * @author Tony Zhai
 */
public class ShellSort {

    public static void sort(int[] array) {
        int current = 0;
        int j = 0;
        int gap = 1;
        int length = array.length;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                current = array[i];
                j = i - gap;
                while (j >= gap - 1 && array[j] > current) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = current;
            }
            gap = (gap - 1) / 3;
            System.out.println("gap="+gap);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 20, 40, 1, 1, 5, 37, 38, 22};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
