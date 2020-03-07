package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;

public class MergeForIntArraySort {

    public static void sort(int[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }

        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);

    }

    private static void mergeSort(int[] array, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid, temp);
            mergeSort(array, mid + 1, high, temp);
            merge(array, low, mid, high, temp);
        }

    }

    private static void merge(int[] array, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < (array[j])) {
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
        int[] array = new int[]{2, 20, 40, 1, 1, 5, 37, 38};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
