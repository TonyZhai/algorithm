package com.tonyzhai.practise.four;

import java.util.Random;

/**
 * Created by Administrator on 1/30/2016.
 */
public class SortUtils {
    static final int LENGTH = 10;
    static final int RANGE = 100;
    static int[] template = new int[LENGTH];

    static {
        Random random = new Random();
        for(int i = 0; i < template.length; i++){
            template[i] = random.nextInt(RANGE);
        }
    }
    public static void bubbleSort(int[] array){
        if(isAvailableArray(array)) {
            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array.length - i - 1; j++)
                    if (array[j] > array[j + 1])
                        swap(array, j, j + 1);
        }
    }

    public static void insertionSort(int[] array){
        if(isAvailableArray(array)){
            int current, j;
            for(int i = 1; i < array.length; i++){
                current = array[i];
                j = i -1;
                while(j >= 0 && array[j] > current){
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        }
    }

    public static void selectionSort(int[] array){
        if(isAvailableArray(array)){
            int minIndex = -Integer.MAX_VALUE;
            for(int i = 0; i < array.length; i++){
                minIndex = i;
                for(int j = i + 1; j < array.length; j++){
                    if(array[j] < array[minIndex]){
                        minIndex = j;
                    }
                }
                if(minIndex != i){
                    swap(array, minIndex, i);
                }
            }
        }
    }

    public static void heapSort(int[] array){
        if(isAvailableArray(array)){
            buildMaxHeap(array);
            for(int i = 0; i < array.length; i++){
                swap(array, 0 , array.length - i - 1);
                adjustMaxHeap(array, 1, array.length - i - 1);
            }
        }
    }

    private static void buildMaxHeap(int[] array) {
        for(int i = array.length / 2; i > 0; i--){
            adjustMaxHeap(array, i, array.length);
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
            swap(array, largestSeq - 1, parentSeq - 1);
            adjustMaxHeap(array, largestSeq, heapSize);
        }
    }

    public static void mergeSort(int[] array){
        if(isAvailableArray(array)){
            int[] temp = new int[array.length];
            mergeSort(array, 0, array.length - 1, temp);
        }
    }

    private static void mergeSort(int[] array, int low, int high, int[] temp) {
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(array, low, mid, temp);
            mergeSort(array, mid + 1, high, temp);
            merge(array, low, mid, high, temp);
        }
    }

    private static void merge(int[] array, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = 0;
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i <= mid){
            temp[k++] = array[i++];
        }
        while(j <= high){
            temp[k++] = array[j++];
        }
        for(i = 0; i < k; i++){
            array[low + i] = temp[i];
        }
    }

    public static void quickSort(int[] array){
        if(isAvailableArray(array)){
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high){
            int pivot = getPivot(array, low, high);
            quickSort(array, low, pivot);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int getPivot(int[] array, int low, int high) {
        int pivotValue = array[low];
        while(low < high){
            while(low < high && array[high] >= pivotValue) high--;
            array[low] = array[high];
            while(low < high && array[low] <= pivotValue) low++;
            array[high] = array[low];
        }
        array[low] = pivotValue;
        return low;
    }

    public static void shellSort(int[] array){
        if(isAvailableArray(array)){
            int gap = 1, current, j;
            while(gap < array.length / 3)
                gap = gap * 3 + 1;
            while(gap > 0){
                for(int i = gap; i < array.length; i++){
                    current = array[i];
                    j = i - gap;
                    while(j >= gap - 1 && array[j] > current){
                        array[j + gap] = array[j];
                        j -= gap;
                    }
                    array[j + gap] = current;
                }
                gap = (gap - 1) / 3;
            }
        }
    }

    private static boolean isAvailableArray(int[] array){
        return array != null && array.length > 1;
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static<T> void print(String name, int[] array){
        System.out.println(name);
        for(int data : array){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print("Original Array:", template);
        int[] array = template.clone();
        bubbleSort(array);
        print("Bubble Sort:", array);
        array = template.clone();
        insertionSort(array);
        print("Insertion Sort:", array);
        array = template.clone();
        selectionSort(array);
        print("Selection Sort:", array);
        array = template.clone();
        heapSort(array);
        print("Heap Sort:", array);
        array = template.clone();
        mergeSort(array);
        print("Merge Sort:", array);
        array = template.clone();
        quickSort(array);
        print("Quick Sort:", array);
        array = template.clone();
        shellSort(array);
        print("Shell Sort:", array);
    }
}
