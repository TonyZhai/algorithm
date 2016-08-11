package com.tonyzhai.practise.six;

/**
 * Created by Administrator on 5/31/2016.
 */
public class BinarySearch {
    static int[] array = new int[]{1,2,3,4,5,6,7,8,9};

    static int search1(int[] array, int key){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] == key){
                return mid;
            } else if(array[mid] > key){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }

    static int search2(int[] array, int key){
        return search2(array, 0, array.length - 1, key);
    }

    static int search2(int[] array, int low, int high, int key){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(array[mid] == key){
            return mid;
        } else if(array[mid] > key){
            return search2(array, low, mid - 1, key);
        } else{
            return search2(array, mid + 1, high, key);
        }
    }

    public static void main(String[] args) {
        System.out.println(search1(array, 0));
        System.out.println(search1(array, 1));
        System.out.println(search1(array, 2));
        System.out.println(search1(array, 3));
        System.out.println(search1(array, 4));
        System.out.println(search1(array, 5));
        System.out.println(search1(array, 6));
        System.out.println(search1(array, 7));
        System.out.println(search1(array, 8));
        System.out.println(search1(array, 9));
        System.out.println(search1(array, 10));
        System.out.println("----------------------------");
        System.out.println(search2(array, 0));
        System.out.println(search2(array, 1));
        System.out.println(search2(array, 2));
        System.out.println(search2(array, 3));
        System.out.println(search2(array, 4));
        System.out.println(search2(array, 5));
        System.out.println(search2(array, 6));
        System.out.println(search2(array, 7));
        System.out.println(search2(array, 8));
        System.out.println(search2(array, 9));
        System.out.println(search2(array, 10));
    }
}
