package com.tonyzhai.practise.date20200223;

import java.util.ArrayList;
import java.util.List;

public class Leetcode {

    public static int[] decompressRLElist(int[] nums) {
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);

        }
        if (nums.length <= 2 || nums.length >= 100 || nums.length % 2 != 0) {
            return null;
        }
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums.length) {
            for (int j = 1; j <= nums[i]; j++) {
                result.add(nums[i + 1]);
            }
            i += 2;
        }
        int[] arr = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            System.out.println(result.get(k));
            arr[k] = result.get(k);
        }
        return arr;
    }

    public static int numberOfSteps (int num) {
        int result = num;
        while(result != 0) {
            if(result%2 == 0) {
                result = result / 2;
            } else {
                result -= 1;
            }
        }
        return result;
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, mx = -1; i >= 0; --i)
            mx = Math.max(arr[i], arr[i] = mx);
        return arr;
    }


    public static void main(String[] args) {
//        decompressRLElist(new int[]{42,39});
//        System.out.println(numberOfSteps(14));
//        System.out.println();
//        System.out.println(Integer.toBinaryString(98));
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(2 & 1));
//        System.out.println(5 >> 1);
//
//        System.out.println(Integer.toBinaryString('A'));
//        System.out.println(Integer.toBinaryString((char)32));
//        System.out.println(Integer.toBinaryString('a'));
//        System.out.println(Integer.toBinaryString('A' | (char)32));
//        System.out.println(Integer.toBinaryString('B' | (char)32));
//        System.out.println((char)('B' | (char)32));
        replaceElements(new int[]{17,18,5,4,6,1});
    }
}
