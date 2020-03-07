package com.tonyzhai.practise;

import java.util.Arrays;


public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        return helper(nums, 0, sum / 2);

    }

    private boolean helper(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }

        if (index == nums.length || target < 0) {
            return false;
        }

        // 当前递归可以找到返回true
        if (helper(nums, index + 1, target - nums[index])) {
            return true;
        }

        // 跳过重复数字，eg 1,1, ... 100,前边一堆1，如果第一个1往后递归找不到合适的那么，他后边的
        // 那一堆1也不会找到的，所以跳过相同的数字
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        // 当前递归找不到，说明上边那个if返回的false，所以跳出那个递归方法，等于index没有 + 1，然后开始继续找
        return helper(nums, j, target);

    }

    // DP[i] = DP[i] || DP[i - num]
    public boolean canPartition1(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // 如果是奇数则不可能存在两个equals的subset
        if ((sum & 1) == 1) {
            return false;
        }

        // 如果找到subset的和是整个数组sum的一半，说明另一半也是这个值，说明存在
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {

            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    /**
                     * 当i >= num，判断当前dp[i]是true还是false的逻辑是
                     * 要么当前已经是true，即dp[i] == true或者减去当前值的dp值是true，即dp[i - num] == true
                     * 证明存在一个值加上当前值等于i
                     */
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            // 判断是否提前找到，dp[sum] == true说明存在subset，可以避免后续非必要的循环
            if (dp[sum] == true) {
                return true;
            }
        }

        return dp[sum];

    }

    public static void main(String[] args) {
        new LeetCode416().canPartition(new int[]{1, 5, 11, 5});
        new LeetCode416().canPartition1(new int[]{1, 5, 11, 5});
    }
}
