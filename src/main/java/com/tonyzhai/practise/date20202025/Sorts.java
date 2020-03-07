package com.tonyzhai.practise.date20202025;

import com.tonyzhai.practise.SortUtils;

public class Sorts {

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j < arr.length - 1; j++) {
                if(arr[i] < arr[j]) {
                    SortUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {

    }


}
