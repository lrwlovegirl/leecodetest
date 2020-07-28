package com.lrw.algorithm.string.middle;

/**
 * 最长公共前缀
 *
 * String[] a={"abcde","abcca","abc","abcfw","abca"}
 * 输出: abc
 *
 */
public class LongestCommonPrefix {

   private static String[] stringArray={"abcde","abcca","abc","abcfw","abca"};

   public static String longestCommonPrefix(String[] str){
       int len = str.length;//字符串个数
       String prefix="";
        if (len!=0){
            prefix=str[0];//取第一个做标杆
        }
        for (int x=0;x<len;x++){
            while(!str[x].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
       return prefix;
   }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(stringArray));
    }



}
