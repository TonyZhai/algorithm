package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class BubbleSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
    }
}
