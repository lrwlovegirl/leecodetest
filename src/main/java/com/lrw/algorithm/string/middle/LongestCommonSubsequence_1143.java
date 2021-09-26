package com.lrw.algorithm.string.middle;

import sun.security.krb5.internal.ASRep;

import java.util.ArrayList;
import java.util.List;

/**
 *给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 */
public class LongestCommonSubsequence_1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int m = text1.length() , n =text2.length();

        int [][] dp = new int[m+1][n+1];

        for (int x=1;x<=m;x++){
            char c = text1.charAt(x-1);
            for (int y = 1 ;y<=n;y++){
                char c1 = text2.charAt(y-1);
                if (c == c1){
                    dp[x][y] = dp[x-1][y-1] +1;
                }else {
                    dp[x][y] = Math.max(dp[x][y-1],dp[x-1][y]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

}
