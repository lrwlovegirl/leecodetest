package com.lrw.algorithm.binarySearch.middle;

/**
 * 29. 两个整数相除，不允许使用乘号，和除号
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideIntegerWithOutDivde {

    public static int divide(int dividend, int divisor) {
        //baseCase
        if (dividend>=Integer.MAX_VALUE||dividend<=Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (dividend == 0||Math.abs(dividend)<Math.abs(divisor)) return 0;
        if (dividend==divisor) return 1;
        boolean flag = false; //记录结果是否是负数还是正数
        //最后结果是整数
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            flag = true;
        }
        //都取绝对值
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int[] nums = new int[dividend];
        //给数组赋值
        for (int x = 0, j = 1; x <= dividend - 1; x++, j++) {
            nums[x] = j;
        }
        int low = 0; //左边指针位置
        int hight = dividend - 1;//右边指针位置
        //二分查找开始
        int midResult = 0;
        try {
            while (low <= hight) {
                int middle = (low + hight) / 2;
                midResult = nums[middle];//中间位置数组值
                int sum = 0;
                for (int x = 0; x < midResult; x++) {
                    sum = sum + divisor;
                }
                if (sum == dividend) {//刚好整除
                    return flag ? midResult : -midResult;
                } else if (sum < dividend) {
                    if (sum + divisor > dividend) {
                        return flag ? midResult : -midResult;
                    }
                    low = middle + 1;
                } else {
                    hight = middle - 1;
                }
            }
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
        return flag ? midResult : -midResult;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
        //System.out.println(Integer.MIN_VALUE);
    }
}

