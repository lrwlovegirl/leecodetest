package com.lrw.algorithm.number.middle;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 */
public class GetSum_371 {

    public static int getSum(int a, int b) {
        if (a == 0 ){return  b;}
        if (b == 0) {return a;}
        while (b!=0){
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

}
