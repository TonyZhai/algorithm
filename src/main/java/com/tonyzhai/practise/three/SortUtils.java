package com.tonyzhai.practise.three;

import java.util.Random;

public class SortUtils {
    static final int LENGTH = 10;
    static final int RANGE = 100;
    static Integer[] template = new Integer[LENGTH];

    static {
        Random random = new Random();
        for(int i = 0; i < template.length; i++){
            template[i] = random.nextInt(RANGE);
        }
    }
    public static<T extends Comparable<T>> void bubbleSort(T[] array){
        if(isAvailableArray(array)){
            T temp;
            int length = array.length;
            for(int i = 0; i < length; i++){
                for(int j = 0; j < length - i - 1; j++){
                    if(array[j].compareTo(array[j + 1]) > 0){
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static<T extends Comparable<T>> void insertionSort(T[] array){
        if(isAvailableArray(array)){
            T current;
            int j;
            for(int i = 1; i < array.length; i++){
                current = array[i];
                j = i - 1;
                while(j >= 0 && array[j].compareTo(current) > 0){
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        }
    }

    public static<T extends Comparable<T>> void selectionSort(T[] array){
        if(isAvailableArray(array)){
            T min;
            int index = 0;
            int length = array.length;
            for(int i = 0; i < length; i++){
                min = array[i];
                index = i;
                for(int j = i + 1; j < length; j++){
                    if(array[j].compareTo(array[i]) < 0){
                        array[i] = array[j];
                        index = j;
                    }
                }
                if(index != i){
                    array[index] = min;
                }
            }
        }
    }

    public static<T extends Comparable<T>> void heapSort(T[] array){
        if(isAvailableArray(array)){
            buildMaxHeap(array);
            int length = array.length;
            T temp;
            for(int i = 0; i < length; i++){
                temp = array[0];
                array[0] = array[length - i - 1];
                array[length - i - 1] = temp;
                adjustMaxHeap(array, 1, length - i - 1);
            }
        }
    }

    private static<T extends Comparable<T>> void buildMaxHeap(T[] array) {
        int length = array.length;
        for(int i = length / 2; i > 0; i--){
            adjustMaxHeap(array, i, length);
        }
    }

    private static<T extends Comparable<T>> void adjustMaxHeap(T[] array, int parentSeq, int heapSize) {
        int leftSeq = parentSeq * 2;
        int rightSeq = parentSeq * 2 + 1;
        int largestSeq = parentSeq;
        if(leftSeq <= heapSize && array[leftSeq - 1].compareTo(array[largestSeq - 1]) > 0){
            largestSeq = leftSeq;
        }
        if(rightSeq <= heapSize && array[rightSeq - 1].compareTo(array[largestSeq - 1]) > 0){
            largestSeq = rightSeq;
        }
        if(largestSeq != parentSeq){
            T temp = array[parentSeq - 1];
            array[parentSeq - 1] = array[largestSeq - 1];
            array[largestSeq - 1] = temp;
            adjustMaxHeap(array, largestSeq, heapSize);
        }
    }

    public static<T extends Comparable<T>> void mergeSort(T[] array){
        if(isAvailableArray(array)){
            T[] temp = array.clone();
            mergeSort(array, 0, array.length - 1, temp);
        }
    }

    private static<T extends Comparable<T>> void mergeSort(T[] array, int low, int high, T[] temp) {
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(array, low, mid, temp);
            mergeSort(array, mid + 1, high, temp);
            merge(array, low, mid, high, temp);
        }
    }

    private static<T extends Comparable<T>> void merge(T[] array, int low, int mid, int high, T[] temp) {
        int i = low, j = mid + 1, k = 0;
        while(i <= mid && j <= high){
            if(array[i].compareTo(array[j]) < 0){
                temp[k++] = array[i++];
            } else{
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

    public static<T extends Comparable<T>> void quickSort(T[] array){
        if(isAvailableArray(array)){
            quickSort(array, 0, array.length - 1);
        }
    }

    private static<T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if(low < high){
            int pivot = getPivot(array, low, high);
            quickSort(array, low, pivot);
            quickSort(array, pivot + 1, high);
        }
    }

    private static<T extends Comparable<T>> int getPivot(T[] array, int low, int high) {
        T pivotValue = array[low];
        while(low < high){
            while(low < high && array[high].compareTo(pivotValue) >= 0){
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low].compareTo(pivotValue) <= 0){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivotValue;
        return low;
    }

    public static<T extends Comparable<T>> void shellSort(T[] array){
        if(isAvailableArray(array)){
            int length = array.length;
            int gap = 1;
            while(gap < length / 3){
                gap = gap * 3 + 1;
            }
            T current;
            int j;
            while(gap > 0){
                for(int i = gap; i < length; i++){
                    current = array[i];
                    j = i - gap;
                    while(j >= gap - 1 && array[j].compareTo(current) > 0){
                        array[j + gap] = array[j];
                        j -= gap;
                    }
                    array[j + gap] = current;
                }
                gap = (gap - 1) / 3;
            }
        }
    }

    public static<T> boolean isAvailableArray(T[] array){
        return array != null && array.length > 1;
    }

    public static<T> void print(String name, T[] array){
        System.out.println(name);
        for(T data : array){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print("Original Array:", template);
        Integer[] array = template.clone();
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
