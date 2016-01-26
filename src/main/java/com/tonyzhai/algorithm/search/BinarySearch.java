package com.tonyzhai.algorithm.search;
/**
 * Binary search practise
 *
 * @author tony
 *
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 12, 15, 21, 33, 57, 76, 79, 120};
        int data1 = 120;
        int data2 = 1;
        System.out.println("value " + data1 + " index is "+ search1(array, data1));
        System.out.println("value " + data2 + " index is "+ search2(array, data2));
    }

    /**
     * binary search recursive implementation
     * @param array
     * @param data
     * @return
     */
    public static int search1(int[] array, int data) {
        if(array == null || array.length == 0){
            System.out.println("empty array");
            return -1;
        }
        if(data < array[0] || data > array[array.length - 1]){
            System.out.println("array has not this value");
            return -1;
        }
        return search(array, data, 0, array.length - 1);
    }

    private static int search(int[] array, int data, int low, int high) {
        int mid = (low + high) / 2;
        if(low > high){
            System.out.println("array has not this value");
            return -1;
        }
        if(array[mid] == data){
            return mid;
        }else if(data < array[mid]){
            return search(array, data, 0, mid - 1);
        }else{
            return search(array, data, mid + 1, high);
        }
    }

    /**
     * binary search loop implementation
     *
     * @param array
     * @param data
     * @return
     */
    public static int search2(int[] array, int data){
        if(array == null || array.length == 0){
            System.out.println("empty array");
            return -1;
        }
        if(data < array[0] || data > array[array.length - 1]){
            System.out.println("array has not this value");
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] == data){
                return mid;
            }else if(data < array[mid]){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        System.out.println("array has not this value");
        return -1;
    }
}