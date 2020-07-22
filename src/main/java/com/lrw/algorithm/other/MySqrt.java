package com.lrw.algorithm.other;

import java.math.BigInteger;
//实现sqrt函数
//https://leetcode-cn.com/problems/sqrtx/
//应该使用二分查找
public class MySqrt {

    //解法正确，超时，暴力破解
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        BigInteger xbig = null;
        BigInteger ybig = null;
        boolean flag = false;
        if (x > 10000000) {
            xbig = new BigInteger(String.valueOf(x));
            flag = true;
        }
        //46341的平方大于Integer.Max_value
        int result = 0;
        for (int y = 1; y < Integer.MAX_VALUE; y++) {
            if (flag) {
                ybig = new BigInteger(String.valueOf(y + 1));
                ybig = ybig.pow(2);
                if ((y * y) == x || (ybig.compareTo(xbig)) > 0) {
                    result = y;
                    break;
                }
            }
            if ((y * y) == x || ((y + 1) * (y + 1)) > x) {
                result = y;
                break;
            }
        }
        return result;
    }

    /**这是搞笑一下
     * 执行用时：1 ms
     * 内存消耗：37.2 MB
     */
    public static int mySqrt1(int x) {
        return (int) Math.pow(x, 0.5);
    }



    public static void main(String[] args) {
        System.out.println(mySqrt1(2147395600 ));
    }
}
