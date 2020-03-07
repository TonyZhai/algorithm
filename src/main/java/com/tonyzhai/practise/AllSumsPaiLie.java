package com.tonyzhai.practise;

import java.util.ArrayList;
import java.util.List;

public class AllSumsPaiLie {

    static List<Integer> sums = new ArrayList<>();

    public void canPartition(int[] nums) {
        int sum = nums[0];
        int k = 0;
        helper(nums, 0, sum, k);

    }

    private void helper(int[] nums, int index, int sum, int k) {
        if (index == nums.length) {
            return;
        }

        sums.add(sum);

        if (index < nums.length - 1) {
            sum += nums[index + k];
        }

        helper(nums, index + 1, sum, k + 1);
        helper(nums, index + 1, sum, k);


    }

    public static void main(String[] args) {
        new AllSumsPaiLie().canPartition(new int[]{1, 5, 11, 5});

        for (int i : sums) {
            System.out.println(i);
        }
    }
}
