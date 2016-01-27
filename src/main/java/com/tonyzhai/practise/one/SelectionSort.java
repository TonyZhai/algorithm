package com.tonyzhai.practise.one;

/**
 * Created by Administrator on 1/26/2016.
 */
public class SelectionSort {
    public static void sort(int[] array){
        if(array == null){
            return;
        }
        if(array.length == 0 || array.length == 1){
            return;
        }
        int current = 0;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            current = array[i];
            index = -1;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[i]){
                    array[i] = array[j];
                    index = j;
                }
            }
            if(index != -1)
                array[index] = current;
        }
    }
}
