package com.lrw.algorithm.number.simple;

/**
 * 简单
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 输入: 121
 输出: true

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class PalindromeNum {
    /**
     * 执行用时：13 ms
     * 内存消耗：39.6 MB
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x<0 || (x % 10 == 0 && x != 0))return false;
        String value = String.valueOf(x);
        StringBuffer sb = new StringBuffer(value);
        if (value.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

}
