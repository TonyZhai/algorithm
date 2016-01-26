package com.tonyzhai.practise;

/**
 * Created by Administrator on 1/26/2016.
 */
public class SortTest {
    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 3, 1, 5, 8};
        BubbleSort.sort(array);
        printArray(array);
        array = new int[]{2, 9, 3, 1, 5, 8};
        InsertionSort.sort(array);
        printArray(array);
        array = new int[]{2, 9, 3, 1, 5, 8};
        MergeSort.sort(array);
        printArray(array);
        array = new int[]{2, 9, 3, 1, 5, 8};
        SelectionSort.sort(array);
        printArray(array);
        array = new int[]{2, 9, 3, 1, 5, 8};
        HeapSort.sort(array);
        printArray(array);
    }
}
