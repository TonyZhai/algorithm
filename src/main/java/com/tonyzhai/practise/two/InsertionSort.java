package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class InsertionSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        int current, j;
        for(int i = 1; i < array.length; i++){
            current = array[i];
            j = i - 1;
            while(j >= 0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
