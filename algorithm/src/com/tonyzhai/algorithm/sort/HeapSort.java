package com.tonyzhai.algorithm.sort;

public class HeapSort {
    public static void sort(int[] array){
        System.out.println("original array, the array size is " + array.length);
        display(array);
        System.out.println("adjust original array to big heap:");
        buildMaxHeap(array);
        display(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println("=========================loop " +(i + 1)+ " start===========================");
            System.out.println("swap element " + array[0] + " and element " + array[array.length - 1 - i]);
            swap(array, 0, array.length - 1 - i);
            System.out.println("after swap, the array list is:");
            display(array);
            System.out.println("current loop's biggest element is  " + array[array.length - 1 - i] + " ,its index is " +(array.length - 1 - i)+ ", then adjust the first " + (array.length - 1 - i) + " element to big heap:");
            maxHeapify(array, 1, array.length - 1 - i);
            display(array);
            System.out.println("=========================loop " +(i + 1)+ " end===========================");
        }
    }

    private static void buildMaxHeap(int[] array) {
        for(int i = array.length/2; i > 0; i--){
            maxHeapify(array, i, array.length);
        }
        //why index cannot start with 0
//        for(int i = 0; i < array.length / 2; i++){
//            maxHeapify(array, i + 1, array.length);
//        }
    }

    private static void maxHeapify(int[] array, int parentSeq, int heapSize) {
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
            swap(array, parentSeq - 1, largestSeq - 1);
            maxHeapify(array, largestSeq, heapSize);
        }
    }

    private static void swap(int[] array, int parentIndex, int largestIndex) {
        int temp = array[parentIndex];
        array[parentIndex] = array[largestIndex];
        array[largestIndex] = temp;
    }

    private static void display(int[] array) {
        for(int data : array){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        sort(new int[]{23, 31, 76, 2, 19, 99, 129, 86});
    }
}
