package com.tonyzhai.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 
 * 'B' -> 2 
 * ... 
 * 'Z' -> 26 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
 * (12). Example 2:
 * 
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 */
class LC91 {

    /**
     * DP
     * 
     * dp[i]代表i这个位置能够代表的所有字母的数量之和
     * 
     * 2: 2 -> 1
     * dp[0] = 1;
     * 22: 2,2; 22 -> 2
     * 前一位 2， 前两位 22，2 > 0 +1, 22 > 0 and <= 26 + 1, so 2
     * dp[1] = 2
     * 226: 2,2,6;2,26;22,6 ->3
     * 前一位 6，前两位 26 6 > 0 dp[2] = dp[2] + dp[2-1] (当前为前一位历史和) = 2; 26  > 0 and <= 26, 
     * so dp[2] = dp[2] + dp[2-2]（当前2位前历史和）
     * 
     * 
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first > 0) {
                dp[i] += dp[i - 1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        System.out.println(new LC91().numDecodings("226"));
    }
}