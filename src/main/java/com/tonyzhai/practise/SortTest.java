package com.tonyzhai.practise;

import com.tonyzhai.algorithm.sort.ShellSort;

import java.util.Random;

/**
 * Created by Administrator on 1/26/2016.
 */
public class SortTest {
    static int[] template = new int[30];
    static{
        for(int i = 0; i < template.length; i++){
            template[i] = new Random().nextInt(1000);
        }
    }
    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = template.clone();
        long startTime = System.currentTimeMillis();
        QuickSort.sort(array);
        System.out.println("QuickSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        HeapSort.sort(array);
        System.out.println("HeapSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        MergeSort.sort(array);
        System.out.println("MergeSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        SelectionSort.sort(array);
        System.out.println("SelectionSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        InsertionSort.sort(array);
        System.out.println("InsertionSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        BubbleSort.sort(array);
        System.out.println("BubbleSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
        array = template.clone();
        startTime = System.currentTimeMillis();
        ShellSort.sort(array);
        System.out.println("ShellSort use time is " + (System.currentTimeMillis() - startTime) + "ms");
        printArray(array);
    }
}
