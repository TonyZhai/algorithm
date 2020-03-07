package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class InsertionSort {

    public static void sort(int[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,1};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
