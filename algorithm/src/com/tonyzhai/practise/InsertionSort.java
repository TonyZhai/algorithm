package com.tonyzhai.practise;

/**
 * Created by Administrator on 1/26/2016.
 */
public class InsertionSort {
    public static void sort(int[] array){
        if(array == null){
            return;
        }
        if(array.length == 0 || array.length == 1){
            return;
        }
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j] < array[j - 1]){
                    SortUtils.swap(array, j, j - 1);
                }
            }
        }
    }
}
