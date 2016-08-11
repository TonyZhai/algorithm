package com.tonyzhai.practise.six;

/**
 * Created by Administrator on 6/2/2016.
 */
public class SelectionSort {
    static int[] array = new int[]{6,7,5,8,2,1,9,3,4};
    static void sort(int[] array){
        int minIndex = 0;
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            minIndex = i;
            temp = array[i];
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    static void print(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        sort(array);
        print(array);
    }
}
