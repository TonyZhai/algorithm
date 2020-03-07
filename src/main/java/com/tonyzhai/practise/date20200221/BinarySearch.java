package com.tonyzhai.practise.date20200221;

public class BinarySearch {

    public static int search(int data, int[] array) {
        return search(data, array, 0, array.length - 1);
    }

    public static int search(int data, int[] array, int low, int high) {
        if (low > high) {
            System.out.println("array has not this value");
            return -1;
        }
        int mid = (low + high) / 2;
        if (data == array[mid]) {
            return mid;
        } else if (data > array[mid]) {
            return search(data, array, mid + 1, high);
        } else {
            return search(data, array, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 6, 10, 12, 33, 39, 110, 320};
        System.out.println(search(30, array));
    }
}
