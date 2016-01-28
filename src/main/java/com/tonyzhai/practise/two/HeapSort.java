package com.tonyzhai.practise.two;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/27/2016.
 */
public class HeapSort {
    public static void sort(int[] array){
        if(!SortUtils.isArrayAvailable(array)){
            return;
        }
        buildMaxHeap(array);
        int length = array.length;
        for(int i = 0; i < length; i++){
            SortUtils.swap(array, 0, length - 1 - i);
            adjustMaxHeap(array, 1, length - 1 - i);
        }
    }

    private static void buildMaxHeap(int[] array) {
        int length = array.length;
        for(int i = length / 2; i > 0; i--){
            adjustMaxHeap(array, i, length);
        }
    }

    private static void adjustMaxHeap(int[] array, int parentSeq, int heapSize) {
        int leftSeq = parentSeq * 2;
        int rightSeq = parentSeq * 2 + 1;
        int largestSeq = parentSeq;

        if(leftSeq <= heapSize && array[leftSeq - 1] > array[largestSeq - 1]){
            largestSeq = leftSeq;
        }
        if(rightSeq <= heapSize && array[rightSeq - 1] > array[largestSeq - 1]){
            largestSeq = rightSeq;
        }
        if(largestSeq != parentSeq){
            SortUtils.swap(array, largestSeq - 1, parentSeq - 1);
            adjustMaxHeap(array, largestSeq, heapSize);
        }
    }
}
