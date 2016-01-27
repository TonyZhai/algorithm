package com.tonyzhai.practise.one;

import com.tonyzhai.practise.SortUtils;

/**
 * Created by Administrator on 1/26/2016.
 */
public class HeapSort {
    public static void sort(int[] array){
        if(array == null){
            return;
        }
        if(array.length == 0 || array.length == 1){
            return;
        }
        buildMaxHeap(array);
        for(int i = 0; i < array.length; i++){
            SortUtils.swap(array, 0, array.length - 1 - i);
            adjustMaxHeap(array, 1, array.length - 1 - i);
        }
    }

    private static void buildMaxHeap(int[] array) {
        for(int i = array.length / 2; i > 0; i--){
            adjustMaxHeap(array, i, array.length);
        }
        //it must be from the bottom up
//        for(int i = 0; i < array.length / 2; i++){
//            adjustMaxHeap(array, i + 1, array.length);
//        }
    }

    private static void adjustMaxHeap(int[] array, int parentSeq, int heapSize) {
        int leftSeq = parentSeq * 2;
        int rightSeq = parentSeq * 2 + 1;
        int largestSeq = parentSeq;
        if(leftSeq <= heapSize && array[leftSeq - 1] > array[parentSeq - 1]){
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
