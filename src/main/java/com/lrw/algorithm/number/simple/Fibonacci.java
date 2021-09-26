package com.lrw.algorithm.number.simple;

/**
 * 计算斐波那契数列
 * Author: liurenwang
 * time : 2020-8-25
 */
public class Fibonacci {

    public static int resolve1(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return resolve1(n-1)+resolve1(n-2);
    }

    //第100项： 3736710778780434371
    public static long resolve(int n){
        int[] result = new int[]{0,1};
        if (n<2){
            return result[n];
        }
        long numOne = 1;
        long numTwo = 0;
        long num = 0;
        for (int i = 2; i <= n; i++) {
            num = numOne+ numTwo;
            numTwo = numOne;
            numOne = num;
        }
        return num;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("开始："+start);
        System.out.println(resolve(100));
        long end = System.currentTimeMillis();
        System.out.println("结束："+end+", 花费时间："+String.format(String.valueOf((end-start)/1000),"%f"));
    }

}
