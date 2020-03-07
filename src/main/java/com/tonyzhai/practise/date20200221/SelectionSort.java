package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class SelectionSort {

    public static void sort(int[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int index = -1;
            int current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    array[i] = array[j];
                    index = j;
                }
            }
            if (index != -1) {
                array[index] = current;
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
