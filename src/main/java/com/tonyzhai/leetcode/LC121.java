package com.tonyzhai.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class LC121 {

    /**
     *
     * dp[i][j]代表代表i买入j卖出的最大值
     * dp[0][1] = 0 如果prices[1] < prices[0], 否则 = prices[1] - prices[0]
     *
     * dp[i][i] = max(dp[i][j - 1], dp[j] - prices[i])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        int[][] dp = new int[prices.length][prices.length];
        dp[0][1] = 0;
        if (prices[1] > prices[0]) {
            max = prices[1] - prices[0];
            dp[0][1] = max;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - prices[i]);

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            // maxCur + (prices[i] - prices[i - 1]), prices[i] - prices[i - 1]再加上之前的和如果还是 > 0
            // 则和之前的最大值比较选哪个 Math.max(maxCur, maxSoFar);
            // 如果maxCur + (prices[i] - prices[i - 1])为 < 0，则从0开始重新计算
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
