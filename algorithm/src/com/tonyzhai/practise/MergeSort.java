package com.tonyzhai.practise;

/**
 * Created by Administrator on 1/26/2016.
 */
public class MergeSort {
    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }
    private static void sort(int[] array, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            sort(array, low, middle);
            sort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    private static void merge(int[] array, int low, int middle, int high){
        int lefArrayLength = middle - low + 1;
        //+1 is used to mark last element
        int[] leftArray = new int[lefArrayLength + 1];
        int rightArrayLength = high - middle;
        int[] rightArray = new int[rightArrayLength + 1];
        int i = low;
        int k = 0;
        while(i <= middle){
            leftArray[k++] = array[i++];
        }
        int j = middle + 1;
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
