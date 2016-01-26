package com.tonyzhai.algorithm.sort;

/**
 * ????
 *
 * @author tony
 *
 */
public class CountingSort {
    public static int[] sort(int[] array){
        int maxValue = 0;
        for(int i : array){
            if(i > maxValue){
                maxValue = i;
            }
        }
        int[] temp = new int[array.length];
        int[] countArray = new int[maxValue + 1];

        for(int i : array){
            countArray[i]++;
        }
        for(int i = 1; i <= maxValue; i++){
            countArray[i] = countArray[i] + countArray[i - 1];
        }
        for(int i = array.length - 1; i >= 0; i--){
            temp[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        return temp;
    }

    public static void main(String[] args){
        int[] array = {3, 2, 1, 0, 0, 1, 2, 3, 3, 2, 1};
        array = sort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
