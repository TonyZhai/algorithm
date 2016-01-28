package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class SelectionSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        int current, index;
        for(int i = 0; i < array.length; i++){
            current = array[i];
            index = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[i]){
                    array[i] = array[j];
                    index = j;
                }
            }
            if(index != i){
                array[index] = current;
            }
        }
    }
}
