package com.tonyzhai.leetcode;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class LC139 {

    /**
     * DP
     *
     * leetcode
     * "" "leetcode"
     * "l" "eetcode"
     * ...
     * "leetcode" ""
     *
     * dp[i]标识到i位置是否可以在字典找到
     * dp[0](即"") = true
     * dp[i](即0到i) = dp[j](0到j(0 ~ i - 1)) && dict.contains(s.substring(j, i)) eg: 遍历
     * 所有leetcode
     * i = 1
     * j = 0
     * dp[1] = dp[0](true) && contains("l"(0 ~ 1)) false = false
     *
     * i = 2
     * j = 0
     * dp[2] = dp[0](true) && contains("le"(0 ~ 2)) false = false
     * j = 1
     * dp[2] = dp[1]("l"false) && contains("e"(1 ~ 2)) false = false
     *
     * i = 3
     * j = 0
     * dp[3] = dp[0](true) && contains("lee"(0 ~ 3)) false = false
     * j = 1
     * dp[3] = dp[1]("l"false) && contains("ee"(1 ~ 3)) false = false
     * j = 2
     * dp[3] = dp[2]("le"false) && contains("e"(2 ~ 3)) false = false
     *
     * i = 4
     * j = 0
     * dp[3] = dp[0](true) && contains("leet"(0 ~ 4)) true = true
     * break
     *
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
