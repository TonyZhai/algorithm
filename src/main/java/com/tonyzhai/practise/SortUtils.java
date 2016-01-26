package com.tonyzhai.practise;

/**
 * Created by Administrator on 1/26/2016.
 */
public class SortUtils {
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
