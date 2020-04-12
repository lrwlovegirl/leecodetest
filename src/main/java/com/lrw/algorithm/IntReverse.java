package com.lrw.algorithm;

import java.math.BigInteger;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/reverse-integer/
 * Author liurenwang
 * time 2020-4-12
 */
public class IntReverse {

    /**
     * 第一种思路
     * 很烂的算法，待优化
     * 执行用时 :6 ms, 在所有 Java 提交中击败了8.92%的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了5.06%的用户
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
      if (x<10&&x>=0){return x;}
      boolean flag =false;
      if (x<0){
          flag = true;
          String num = String.valueOf(x);
          num = num.substring(1,num.length());//去除-号
          return toResult(num,flag);
      }
      String num = String.valueOf(x);
      return toResult(num,flag);
    }

    private static  int toResult(String num,boolean flag){
        while (num.endsWith("0")){
            num=num.substring(0,num.length()-1);
        }
        StringBuffer sb = new StringBuffer(num);
        num = sb.reverse().toString();
        if (num.length()>=10){
            Long value  = Long.valueOf(num);
            if (value.longValue()>Integer.MAX_VALUE){
                return 0;
            }
        }
        int result =(flag)?Integer.valueOf("-"+num):Integer.valueOf(num);
        return result;
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了24.13%的用户
     * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了5.06%的用户
     * @param x
     * @return
     */
    public static int reverse2(int x){
        int y = x;
        if(y < 0){
            y *= (-1);
        }
        String num = String.valueOf(y);
        StringBuffer sb = new StringBuffer(num);
        num = sb.reverse().toString();
        try{
            int result = Integer.parseInt(num,10);
            if (x<0){
                return result*(-1);
            }
            return result;
        }catch (Exception e){
            return 0;
        }
    }



    public static void main(String[] args) {
        System.out.println(reverse2(-123));
        //21 4748 3647
        //1534263469
        //System.out.println(reverse(-2147483648));
    }
}
