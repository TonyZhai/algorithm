package com.tonyzhai.practise.date20200221;

import com.tonyzhai.practise.SortUtils;
//https://www.youtube.com/watch?v=j-DqQcNPGbE
public class HeapSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (!SortUtils.isArrayAvailable(array)) {
            return;
        }
        buildMaxHeap(array);
        T temp;
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            SortUtils.swap(array, 0, length - i - 1);
            adjustMaxHeap(array, 1, length - i - 1);
        }
    }

    private static <T extends Comparable<T>> void buildMaxHeap(T[] array) {
        int lastParentSeq = array.length / 2;
        for (int i = lastParentSeq; i > 0; i--) {
            adjustMaxHeap(array, i, array.length);
        }
    }

    private static <T extends Comparable<T>> void adjustMaxHeap(T[] array, int parentNodeSeq, int heapSize) {
        int leftNodeSeq = parentNodeSeq * 2;
        int rightNodeSeq = parentNodeSeq * 2 + 1;
        int largestNodeSeq = parentNodeSeq;
        if (leftNodeSeq <= heapSize && array[leftNodeSeq - 1].compareTo(array[largestNodeSeq - 1]) >= 0) {
            largestNodeSeq = leftNodeSeq;
        }
        if (rightNodeSeq <= heapSize && array[rightNodeSeq - 1].compareTo(array[largestNodeSeq - 1]) >= 0) {
            largestNodeSeq = rightNodeSeq;
        }
        if (largestNodeSeq != parentNodeSeq) {
            SortUtils.swap(array, largestNodeSeq - 1, parentNodeSeq - 1);
            adjustMaxHeap(array, largestNodeSeq, heapSize);
        }
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 20, 40, 1, 1, 5, 37, 38};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
