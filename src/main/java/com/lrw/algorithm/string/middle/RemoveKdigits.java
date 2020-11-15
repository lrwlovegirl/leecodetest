package com.lrw.algorithm.string.middle;

import java.util.LinkedList;
import java.util.List;

/**
 * desc:  402. 移掉K位数字  https://leetcode-cn.com/problems/remove-k-digits/
 * Author: liurenwang
 * time : 2020/11/15 17:50
 */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        if (k>=num.length()){
            return "0";
        }
        char[] chars = num.toCharArray();
        List<Character> list=new LinkedList();
        boolean flag = true;

        for (int i = 0; i <chars.length ; i++) {
            //单调递增
            if (i==0){
                list.add(chars[i]);
                continue;
            }else if ((i-1)>=0){
                if (chars[i]>=chars[i-1]||k==0){//单调递增
                    list.add(chars[i]);
                }else {
                    flag =false;
                    while (!list.isEmpty()&&list.get(list.size()-1)>chars[i]&&k>0){
                        list.remove(list.size()-1);
                        k--;
                    }
                    list.add(chars[i]);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Character c:list){
            sb.append(c);
        }
        String s = sb.toString();
        if (flag||k>0){//是单调递增的
          s = s.substring(0,s.length()-k);
        }
        while (s.startsWith("0")){
            s = s.substring(1);
        }
        if ("".equals(s)){
            return "0";
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(removeKdigits("1173",2));
    }

}
