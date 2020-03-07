package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class ShellSort {

    public static void sort(int[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }
        int gap = 1;
        int length = array.length;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int current = array[i];
                int j = i - gap;
                while (j >= gap - 1 && array[j] > current) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = current;
            }
            gap = (gap - 1) / 1;
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
