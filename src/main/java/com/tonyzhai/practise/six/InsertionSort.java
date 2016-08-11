package com.tonyzhai.practise.six;

/**
 * Created by Administrator on 6/1/2016.
 */
public class InsertionSort {
    static int[] array = new int[]{6,7,5,8,2,1,9,3,4};
    static void sort(int[] array){
        int temp = 0;
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            int j;
            for(j = i - 1; j >= 0 && array[j] > temp; j--){
                array[j + 1] = array[j];
            }
//            while(j >= 0 && array[j] > temp){
//                array[j + 1] = array[j];
//                j--;
//            }
            array[++j] = temp;
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
