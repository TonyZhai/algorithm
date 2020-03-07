package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class BubbleSort {

    public static void sort(int[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 20, 40, 1, 1, 5, 37, 38};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
