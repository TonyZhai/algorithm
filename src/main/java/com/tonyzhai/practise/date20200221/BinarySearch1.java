package com.tonyzhai.practise.date20200221;

public class BinarySearch1 {

    public static int search(int data, int[] array) {
        int[] res = new int[]{-1};
        search(data, array, 0, array.length - 1, res);
        return res[0];
    }

    public static int search1(int data, int[] array) {
        int res = -1;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data <= array[mid]) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void search(int data, int[] array, int low, int high , int[] res) {
        if (low > high) {
            return;
        }
        int mid = (low + high) / 2;
        if (data <= array[mid]) {
            res[0] = mid;
            search(data, array, low, mid - 1, res);
        } else {
            search(data, array, mid + 1, high, res);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,5, 5,5,6};
        System.out.println(search1(5, array));
    }
}
