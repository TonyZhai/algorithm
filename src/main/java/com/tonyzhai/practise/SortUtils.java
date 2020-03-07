package com.tonyzhai.practise;

/**
 * Created by Administrator on 1/26/2016.
 */
public class SortUtils {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean isArrayAvailable(int[] array) {
        return array != null && array.length > 1;
    }

    public static <T> boolean isArrayAvailable(T[] array) {
        return array != null && array.length > 1;
    }
}
