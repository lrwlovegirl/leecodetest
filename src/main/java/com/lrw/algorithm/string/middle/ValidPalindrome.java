package com.lrw.algorithm.string.middle;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        return false;
    }
    private static boolean valid(char[] chars){
       int i = 0 ;
       int j = chars.length-1;
       while (i<j&&chars[i]==chars[j]){
           i++;
           j--;
       }
       return  false;
    }
    public static void main(String[] args) {
        ValidPalindrome vo = new ValidPalindrome();
        System.out.println(vo.hashCode());
    }

}
