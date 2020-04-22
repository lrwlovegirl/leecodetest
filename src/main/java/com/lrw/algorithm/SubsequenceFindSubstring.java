package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 美团2020 Java笔试题: 子序列中找子串
 * 给定一个字符串s:"abc"
 * 给定零一个字符串t:"abc"
 * 他s的字串a b c ab bc abc
 * t子序列 a b c ab ac bc abc
 * s:"aaa"
 * t:"aaa"
 * s子串： a(1) a(2) a(3) aa(12) aa(23)  aaa(123)
 * t子序列 a(1) a(2) a(3) aa(12) aa(13) aa(23) aaa(123)
 * 输出结果 16
 * 如果在子序列中可以找到某个子串，则输出结果+1
 *
 * 暴力破解的方法会超出时间限制
 */

public class SubsequenceFindSubstring {

    //存放子串
    private  static  List<String> subStringList = new ArrayList<>();
    //存放所有子序列

    private static List<String> subStrList = new ArrayList<>();

    public static void allSSubStr(String s){
       //找到s所有的子串
       if (null==s||s.length()==0){
           return ;
       }
       for (int i=0;i<s.length();i++){
           for (int j=i+1;j<=s.length();j++){
               subStringList.add(s.substring(i,j));
           }
       }
    }
    public static void printAllSub(char[] str, int i,String res){
       if (i==str.length){
           subStrList.add(res);
           return ;
       }else{
           printAllSub(str,i+1,res);
           printAllSub(str,i+1,res+str[i]);
       }
   }
    public static void main(String[] args) {
        int result = 0;
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        String t = cin.next();
        //获得s所有的子串
        allSSubStr(s);
        //获取所有子序列
        if (t!=null){
            printAllSub(t.toCharArray(),0,"");
        }
        if (subStringList.size()==0||subStrList.size()==0){
            return;
        }
        for (int x=0;x<subStringList.size();x++){
            String s1 = subStringList.get(x);
            for (int y=0;y<subStrList.size();y++){
                String s2 = subStrList.get(y);
                    if (s1.equals(s2)){
                        result++;
                }
            }
        }
        System.out.println(result);
    }
}
