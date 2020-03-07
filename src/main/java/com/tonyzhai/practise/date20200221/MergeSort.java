package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }

        T[] temp = array.clone();
        mergeSort(array, 0, array.length - 1, temp);

    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high, T[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid, temp);
            mergeSort(array, mid + 1, high, temp);
            merge(array, low, mid, high, temp);
        }

    }

    private static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high, T[] temp) {
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (array[i].compareTo(array[j]) < 0) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (i = 0; i < k; i++) {
            array[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 20, 40, 1, 1, 5, 37, 38};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
