package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;
//https://www.youtube.com/watch?v=gl_XQHTJ5hY
public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }

        quickSort(array, 0, array.length - 1);

    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int mid = getMid(array, low, high);
            quickSort(array, low, mid);
            quickSort(array, mid + 1, high);
        }
    }

    private static <T extends Comparable<T>> int getMid(T[] array, int low, int high) {
        T pivot = array[low];
        while (low < high) {
            while (low < high && array[high].compareTo(pivot) >= 0) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low].compareTo(pivot) <= 0) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 20, 40, 1, 1, 5, 37, 38};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
