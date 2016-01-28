package com.tonyzhai.practise.two;

import jdk.nashorn.tools.Shell;

import java.util.Random;

/**
 * Created by Administrator on 1/27/2016.
 */
public class SortTest {
    static int[] template = new int[10];
    static {
        Random random = new Random();
        for(int i = 0; i < template.length; i++){
            template[i] = random.nextInt(100);
        }
    }

    public static void printArray(String name, int[] array){
        System.out.println(name);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray("original array",template);
        int[] array = template.clone();
        BubbleSort.sort(array);
        printArray("BubbleSort", array);
        array = template.clone();
        InsertionSort.sort(array);
        printArray("InsertionSort", array);
        array = template.clone();
        SelectionSort.sort(array);
        printArray("SelectionSort", array);
        array = template.clone();
        HeapSort.sort(array);
        printArray("HeapSort", array);
        array = template.clone();
        MergeSort.sort(array);
        printArray("MergeSort", array);
        array = template.clone();
        QuickSort.sort(array);
        printArray("QuickSort", array);
        array = template.clone();
        ShellSort.sort(array);
        printArray("ShellSort", array);
    }
}
