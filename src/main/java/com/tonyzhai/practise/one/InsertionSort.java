package com.tonyzhai.practise.one;

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
        int current = 0;
        int j = 0;
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
