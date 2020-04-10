package com.lrw.algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * Author liurenwang
 * time 2020-4-3
 */
public class NoRepeatLongestStr {


    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        //暴力破解
        int ans = 0;
        for (int x = 0; x < len; x++) {
            for (int y = x + 1; y <= len; y++) {
                if (isUnique(s, x, y)) {
                    ans = Math.max(ans, y - x);
                }
            }
        }
        return ans;
    }

    public static boolean isUnique(String s, int x, int y) {
        Set<Character> set = new HashSet<>();
        for (int i = x; i <= y; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcdefg"));
    }

}