package com.tonyzhai.practise.six;

/**
 * Created by Administrator on 5/30/2016.
 */
public class BubbleSort {
    static int[] array = new int[]{6,7,5,8,2,1,9,3,4};
    public static void sort1(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = array.length - 1; j >= (i + 1); j--){
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    static void sort2(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j + 1] < array[j]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void print(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        sort2(array);
        print(array);
    }
}
