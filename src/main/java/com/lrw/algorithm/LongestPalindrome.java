package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文子串
 * 输入 ：aababaa
 *
 */
public class LongestPalindrome {
    /**
     *暴力破解方法
     * 找出字符串所有的子串，然后反转判断
     * 平均时间复杂度：O(n3)
     */
    public static String bruteForce(String str){
        if (null==str||str.trim().length()==0){
            return "";
        }
        //定义集合，存储所有字符串子串
        List<String> list  = new ArrayList<>();
        int len = str.length();
        for (int x=0;x<len;x++){
            for (int y=len;y<=len&&x<=y;y--){
                String s = str.substring(x,y);
                if (s.length()>1){
                    list.add(s);
                }
            }
        }
        //判断所有子串是否是回文
        for(int i=0;i<list.size();i++){
            if (list.get(i).equals(reverse(list.get(i)))){
                return list.get(i);
            }
        }
        return "";
    }

    /**
     * 反转字符串
     * @param s
     * @return
     */
    private  static  String  reverse(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(bruteForce("abcdeffedxx"));
        System.out.println(bruteForce("ababa"));
    }
}
