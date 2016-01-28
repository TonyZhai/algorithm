package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class MergeSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if(low < high){
            int mid = (high + low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int leftArrayLength = mid - low + 1;
        int rightArrayLength = high - mid;
        int[] leftArray = new int[leftArrayLength + 1];
        int[] rightArray = new int[rightArrayLength + 1];
        int i = low, j = mid + 1, k = 0;
        while(i <= mid){
            leftArray[k++] = array[i++];
        }
        k = 0;
        while(j <= high){
            rightArray[k++] = array[j++];
        }
        leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
        rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
        i = 0;
        j = 0;
        k = low;
        while(k <= high){
            if(leftArray[i] <= rightArray[j]){
                array[k++] = leftArray[i++];
            } else{
                array[k++] = rightArray[j++];
            }
        }
    }
}
