package com.tonyzhai.practise.four;

public class BinarySearch {

    public int search(int key, int[] array){
        if(key < array[0] || key > array[array.length - 1]){
            return -1;
        }
        return search(key, array, 0, array.length - 1);
    }

    private int search(int key, int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if(key == array[mid]){
            return mid;
        } else if(key > array[mid]){
            return search(key, array, mid + 1, high);
        } else{
            return search(key, array, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(new BinarySearch().search(1, array));
        System.out.println(new BinarySearch().search(2, array));
        System.out.println(new BinarySearch().search(3, array));
        System.out.println(new BinarySearch().search(4, array));
        System.out.println(new BinarySearch().search(5, array));
        System.out.println(new BinarySearch().search(6, array));
        System.out.println(new BinarySearch().search(7, array));
        System.out.println(new BinarySearch().search(8, array));
        System.out.println(new BinarySearch().search(9, array));
        System.out.println(new BinarySearch().search(10, array));
    }
}
