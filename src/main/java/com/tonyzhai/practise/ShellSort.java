package com.tonyzhai.practise;

/**
 * Add some description
 *
 * @author Tony Zhai
 */
public class ShellSort {
    public static void sort(int[] array){
        int current = 0;
        int j = 0;
        int gap = 1;
        int length = array.length;
        while(gap < length / 3)
            gap = gap * 3 + 1;
        while(gap > 0){
            for(int i = gap; i < length; i++){
                current = array[i];
                j = i - gap;
                while(j >= gap - 1 && array[j] > current){
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = current;
            }
            gap = (gap - 1) / 3;
        }
    }
}
