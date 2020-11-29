package com.lrw.algorithm.string.simple;

import java.util.Arrays;

/**
 * desc: 242. 有效的字母异位词 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * https://leetcode-cn.com/problems/valid-anagram/
 * Author: liurenwang
 * time : 2020/11/22 21:50
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] table = new int[26];
        for (int x=0;x<s.length();x++){
            table[s.charAt(x)-'a']++;
        }
        for (int y=0;y<t.length();y++){
            table[t.charAt(y)-'a']--;
            if (table[t.charAt(y)-'a']<0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram_2(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray,tCharArray);
    }

}
