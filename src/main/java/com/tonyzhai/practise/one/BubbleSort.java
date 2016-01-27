package com.tonyzhai.practise.one;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/26/2016.
 */
public class BubbleSort {

    public static void sort(int[] array){
        if(array == null){
            return;
        }
        if(array.length == 0 || array.length == 1){
            return;
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1])
                    SortUtils.swap(array, j, j + 1);
            }
        }
    }
}
