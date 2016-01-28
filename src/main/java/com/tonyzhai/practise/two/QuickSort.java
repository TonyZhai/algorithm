package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class QuickSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if(low < high){
            int pivot = getPivot(array, low, high);
            sort(array, low, pivot);
            sort(array, pivot + 1, high);
        }
    }

    private static int getPivot(int[] array, int low, int high) {
        int pivotValue = array[low];
        while(low < high){
            while(low < high && array[high] >= pivotValue) high--;
            array[low] = array[high];
            while(low < high && array[low] <= pivotValue) low++;
            array[high] = array[low];
        }
        array[low] = pivotValue;
        return low;
    }
}
