package com.tonyzhai.practise.two;

/**
 * Created by Administrator on 1/27/2016.
 */
public class ShellSort {
    public static void sort(int[] array){
        int length = array.length;
        int gap = 1;
        int current, j;
        while(gap < length / 3)
            gap = gap * 3 + 1;
        while(gap > 0){
            for(int i = gap; i < length; i++){
                current = array[i];
                j = i - gap;
                while(j >= i - gap && array[j] > current){
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = current;
            }
            gap = (gap - 1) / 3;
        }
    }
}
