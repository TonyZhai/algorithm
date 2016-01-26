package com.tonyzhai.algorithm;
/**
 * ?????5
 *      ?????k???
 *
 * ??
 *      ??n???????????k??
 *      ????1?2?3?4?5?6?7?8?8????????4????1?2?3?4?
 *
 * @author tony
 *
 */
public class MinimumNumbers {

    /**
     * @param array
     * @param k
     */
    public static void getMinimumNumbers1(int[] array, int k){
        buildMinHeap(array);
        for(int i = 0; i < k; i++){
            swap(array, 0, array.length - 1 - i);
            adjustMinHeap(array, 1, array.length - i - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void buildMinHeap(int[] array) {
        for(int i = array.length / 2; i > 0; i--){
            adjustMinHeap(array, i, array.length);
        }
    }

    private static void buildMaxHeap(int[] array, int k){
        for(int i = k / 2; i > 0; i--){
            adjustMaxHeap(array, i, k);
        }
        System.out.println("temp max index is " + (k/2));
        System.out.println("temp max value is " + array[k/2]);
    }

    private static void adjustMaxHeap(int[] array, int parentSeq, int size) {
        int leftSeq = parentSeq * 2;
        int rightSeq = parentSeq * 2 + 1;
        int largestSeq = parentSeq;
        if(leftSeq <= size && array[leftSeq - 1] > array[parentSeq - 1]){
            largestSeq = leftSeq;
        }
        if(rightSeq <= size && array[rightSeq - 1] > array[largestSeq - 1]){
            largestSeq = rightSeq;
        }
        if(largestSeq != parentSeq){
            swap(array, largestSeq - 1, parentSeq - 1);
            adjustMaxHeap(array, largestSeq, size);
        }

    }

    private static void adjustMinHeap(int[] array, int parentSeq, int size) {
        int leftSeq = parentSeq * 2;
        int rightSeq = parentSeq * 2 + 1;
        int smallestValueSeq = parentSeq;

        if(leftSeq <= size && array[leftSeq - 1] < array[parentSeq - 1]){
            smallestValueSeq = leftSeq;
        }
        if(rightSeq <= size && array[rightSeq - 1] < array[smallestValueSeq - 1]){
            smallestValueSeq = rightSeq;
        }

        if(smallestValueSeq != parentSeq){
            swap(array, smallestValueSeq - 1, parentSeq - 1);
            adjustMinHeap(array, smallestValueSeq, size);
        }
    }

    /**
     * @param array
     * @param k
     * @return
     */
    public static int[] getMinimumNumbers2(int[] array, int k){
        int[] temp = new int[k];
        int maxIndexInTemp = 0;
        for(int i = 0; i < k; i++){
            temp[i] = array[i];
            if(temp[i] > temp[maxIndexInTemp]){
                maxIndexInTemp = i;
            }
        }
        System.out.println("temp max index is " + maxIndexInTemp);
        System.out.println("temp max value is " + temp[maxIndexInTemp]);

        for(int i = k; i < array.length; i++){
            if(array[i] < temp[maxIndexInTemp]){
                temp[maxIndexInTemp] = array[i];
                for(int j = 0; j < k; j++){
                    if(temp[j] > temp[maxIndexInTemp]){
                        maxIndexInTemp = j;
                    }
                }
                System.out.println("temp max index is " + maxIndexInTemp);
                System.out.println("temp max value is " + temp[maxIndexInTemp]);
            }
        }
        return temp;
    }

    /**
     * @param array
     * @param k
     */
    public static void getMinimumNumbers3(int[] array, int k){
        buildMaxHeap(array, k);
        for(int i = k; i < array.length; i++){
            if(array[i] < array[k / 2 - 1]){
                swap(array, (k / 2 - 1), i);
                adjustMaxHeap(array, 1, k);
            }
        }
    }

    public static void main(String[] args){
        int[] array1 = {5, 1, 4, 3, 2};
        int k = 3;
        getMinimumNumbers1(array1, k);
        for(int i = 0; i < k; i++){
            System.out.print(array1[array1.length - 1 - i] + " ");
        }
        System.out.println();
        int[] array2 = {5, 1, 4, 3, 2};
        array2 = getMinimumNumbers2(array2, k);
        for(int i = 0; i < k; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        int[] array3 = {5, 1, 4, 3, 2};
        getMinimumNumbers3(array3, k);
        for(int i = 0; i < k; i++){
            System.out.print(array3[i] + " ");
        }
    }
}