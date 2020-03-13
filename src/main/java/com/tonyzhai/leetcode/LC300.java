package com.tonyzhai.leetcode;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LC300 {

    /**
     * dp[i]标识当前数字的longest increasing subsequence
     * dp[1] = 1 //至少自己算一个
     *
     * dp[i] = 遍历从0到i的的数，如果这个数字nums[j] < nums[i]，则用这个dp[j] + 1和当前len比较选大的，循环到 < i 取到
     * 最大的len
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC300().lengthOfLIS1(new int[]{8, 9, 2, 5, 3, 7, 101, 18}));
    }
}
