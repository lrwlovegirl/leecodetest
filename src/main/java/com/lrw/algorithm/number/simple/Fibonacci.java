package com.lrw.algorithm.number.simple;

/**
 * 计算斐波那契数列
 * Author: liurenwang
 * time : 2020-8-25
 */
public class Fibonacci {

    public static long resolve1(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return resolve1(n-1)+resolve1(n-2);
    }

    //第100项： 3736710778780434371
    public static int resolve(int n){
        int[] result = new int[]{1,1,2};
        if (n<=2){
            return result[n];
        }
        int numOne = 1;
        int numTwo = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = numOne+ numTwo;
            numTwo = numOne;
            numOne = num;
        }
        return num % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(resolve(44));
    }

}
