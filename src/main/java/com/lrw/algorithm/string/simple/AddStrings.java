package com.lrw.algorithm.string.simple;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * https://leetcode-cn.com/problems/add-strings/
 * Author liurenwang
 * time 2020-8-3
 */
public class AddStrings {


    //和链表相加那道题差不多
    //执行用时：3 ms, 在所有 Java 提交中击败了79.86%的用户
    //内存消耗：39.5 MB, 在所有 Java 提交中击败了94.18%的用户
    public static String addStrings(String num1, String num2) {
        //base case
        if (num1==null) return num2;
        if (num2==null) return num1;
        //正常情况
        int carry = 0; //进位标志
        int num1Len = num1.length()-1;//字符串1长度
        int num2Len = num2.length()-1;//字符串2长度
        StringBuilder resultSb = new StringBuilder();
        //倒置,这里可以进行优化，当某个字符串到头时，如果进位标志为0，则直接append，不需要再进行一系列判断
        for (int x= num1Len,y=num2Len;x>=0||y>=0||carry==1;x--,y--){
            int i = x>=0?num1.charAt(x)-'0':0 ; //位运算
            int j = y>=0?num2.charAt(y)-'0':0;
            int result  = i+j+carry;
            carry = result>=10? 1:0;
            result = result>=10? result-10:result;
            resultSb.append(result);
        }
        return resultSb.reverse().toString();
    }
    //优化之后
    //执行用时：2 ms, 在所有 Java 提交中击败了99.89%的用户
    //内存消耗：39.9 MB, 在所有 Java 提交中击败了48.22%用户
    public static String addStrings2(String num1, String num2) {
        //base case
        if (num1==null) return num2;
        if (num2==null) return num1;
        //正常情况
        int carry = 0; //进位标志
        int num1Len = num1.length()-1;//字符串1长度
        int num2Len = num2.length()-1;//字符串2长度
        StringBuilder resultSb = new StringBuilder();
        //倒置
        for (int x= num1Len,y=num2Len;x>=0||y>=0||carry==1;x--,y--){
            if (x<0&&carry==0){
                resultSb.append(num2.charAt(y));
                continue;
            }
            //字符串num2到头
            if (y<0&&carry==0){
                resultSb.append(num1.charAt(x));
                continue;
            }
            int i = x>=0?num1.charAt(x)-'0':0 ; //位运算
            int j = y>=0?num2.charAt(y)-'0':0;
            int result  = i+j+carry;
            carry = result>=10? 1:0;
            result = result>=10? result-10:result;
            resultSb.append(result);
        }
        return resultSb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9137","5"));
    }
}
