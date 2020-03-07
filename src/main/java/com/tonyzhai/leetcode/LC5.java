package com.tonyzhai.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC5 {

    // Brute force
    public String longestPalindrome(String s) {
        String max = "";
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<String> allCombinations = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.charAt(i) + "";
            allCombinations.add(s1);
            if (i + 1 < s.length()) {
                for (int j = i + 1; j < s.length(); j++) {
                    s1 += s.charAt(j);
                    allCombinations.add(s1);
                }
            }
        }
        for (String s2 : allCombinations) {
            if (isValid(s2) && s2.length() > max.length()) {
                max = s2;
            }
        }
        return max;
    }

    public boolean isValid(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) {
            return false;
        }
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    // Expand solution
    public String longestPalindrome2(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            // 每次都考虑奇数情况和偶数情况，奇数传一个相同元素，类似aba里的 b
            String s1 = extend(s, i, i);
            // 偶数传当前和下一个， 类似 abba里的bb，i是b，i+1也是b
            String s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) {
                max = s1;
            }
            if (s2.length() > max.length()) {
                max = s2;
            }
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                // 如果不相等，说明到这为止不是回文，则跳出循环后返回i，j的回文串
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    // DP solution
    // https://www.youtube.com/watch?v=ZnzvU03HtYk
    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                /**
                 *    abab
                 *    i = 1 a
                 *    j = 0 a
                 *    然后看 i和j上得值相等，然后看 i - 1 和 j + 1是不是回文，依次类推
                 */
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]);

                if (dp[i][j] && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new LC5().longestPalindrome("abab"));
        System.out.println(new LC5().longestPalindrome2("ab"));
//        System.out.println(new LC5().longestPalindrome3("abab"));
    }
}
