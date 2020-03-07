package com.tonyzhai.leetcode;

public class LC242 {

    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'b');
        System.out.println((int)'c');
        System.out.println((int)'z');
        System.out.println('b' - 'a');

        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

}
