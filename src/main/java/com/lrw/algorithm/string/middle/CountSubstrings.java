package com.lrw.algorithm.string.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 */
public class CountSubstrings {


    /**
     * 暴力解法1: 获取所有的字符串，然后遍历
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s.length()==1){
            return 1;
        }
        List<String> list = new ArrayList<>();
        for (int x =0;x<s.length();x++){
            for (int j =x+1;j<=s.length();j++){
                list.add(s.substring(x,j));
            }
        }
        int count = 0;
        for (String s1 : list) {
            StringBuilder sb = new StringBuilder(s1);
            if (s1.equals(sb.reverse().toString())){
                count++;
            }
        }
        return count;
    }

    public static int countSubstrings2(String s) {
        if (s.length()==1){
            return 1;
        }
        int count = 0;
        int length = s.length();
        //遍历所有的字符，作为中心点
        for (int x=0;x<length;x++){
            //1个字符作为中心，或者2个字符作为中心,J=0的时候，1个字符是中心点，j=1的时候2个字符是中心点
           for (int j = 0;j<=1;j++){
               int l = x;

               int r = x+j;
               while (l>=0 && r<length && s.charAt(l)==s.charAt(r)){
                   count++;
                   l--;
                   r++;
                   int y =1;
               }
           }

        }


        return count;
    }



    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println("开始："+begin);
        System.out.println(countSubstrings2("abcaaaaaaaaaaaaaaaaaaaaa"));
        long end = System.currentTimeMillis();
        System.out.println("结束："+end);
        System.out.println(end-begin);
    }
}
