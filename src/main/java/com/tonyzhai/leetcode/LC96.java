package com.tonyzhai.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
class LC96 {

    /**
     * DP
     * dp[0] = 1代表没有数即null的情况
     * dp[1] = 1代表一个数字的bst数量
     * dp[2] = 2代表两个数字的bst数量
     * dp[3] = 5
     * bst特性左子树小于根，右子树大于根，所以
     * 例如 1,2,3,4所有的bst可能性的计算方法是
     * 当1为根，左子树null（即1种），右子树2~4（即3个数的所有bst num）的所有可能，左右相乘 dp[0]*dp[3] = 5
     * 当2为根，左子树只能是1(dp[1] = 1)，右子树3~4（即2个数的所有bst num),同上 = dp[1]*dp[2] = 2
     * 当3为根，左子树1,2的所有可能dp[2],右子树4,dp[1], = dp[2]*dp[1] = 2
     * 当4为根，左子树1,2,3所有可能dp[3], 右子树null dp[0], = dp[3]*dp[0] = 5
     * 
     * 5 + 2 + 2 + 5 = 14
     * 
     */
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];

        // 没数的时候是 1
        dp[0] = 1;

        // 一个数的所有bst num是1
        dp[1] = 1;

        // 从2个数的所有bst num开始计算，递推到n
        for (int i = 2; i <= n; i++) {
            /**
             * eg: i = 2
             * j = 1
             * dp[2] = dp[2] + dp[2 - 1] * dp[1 - 1] = dp[2] + dp[1] * dp[0] = 0 + 1 * 1 = 1
             * 
             * j = 2
             * dp[2] = dp[2] + dp[2 - 2] * dp [2 - 1] = dp[2] + dp[0] * dp[1] = 1 + 1 * 1 = 2
             * 
             * 
             * i = 3
             * j = 1
             * dp[3] = dp[3] + dp[3 - 1] * dp[1 - 1] = dp[3] + dp[2] * dp[0] = 0 + 2 * 1 = 2
             * j = 2
             * dp[3] = dp[3] + dp[3 - 2] * dp[2 - 1] = dp[3] + dp[1] * dp[1] = 2 + 1 * 1 = 3
             * j = 3
             * dp[3] = dp[3] + dp[3 - 3] * dp[3 - 1] = dp[3] + dp[0] * dp[2] = 3 + 1 * 2 = 5
             * 
             * ...
             * 
             */
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC96().numTrees(4));
    }
}