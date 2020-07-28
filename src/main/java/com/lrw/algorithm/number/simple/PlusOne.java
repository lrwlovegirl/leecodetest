package com.lrw.algorithm.number.simple;

import java.math.BigInteger;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    //傻逼了，要将数组转换成整数。。。。
    public static int[] plusOne(int[] digits) {
        if (digits.length > 10) {

        }
        int sum = 0;
        for (int x = 0, j = digits.length - 1; x < digits.length; x++, j--) {
            sum = (int) (sum + digits[x] * Math.pow(10, j));
        }
        sum = sum + 1;
        //多加一位，防止溢出
        int[] a = new int[digits.length + 1];
        for (int x = a.length - 1; x >= 0; x--) {
            if (sum == 0) {
                break;
            }
            ;
            int b = sum % 10;
            a[x] = b;
            sum = (sum - b) / 10;
        }
        if (a[0] == 0) {
            int[] b = new int[a.length - 1];
            for (int i = 0; i < b.length; i++) {
                b[i] = a[i + 1];
            }
            return b;
        }
        return a;
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.63%的用户
     */
    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            //执行到这句话说明数为 9 ，然后本位置0 即可
            digits[i] = 0;
        }
        //执行到这说明传过来的数组全是9
        int[] b = new int[len + 1];
        b[0] = 1;
        return b;
    }

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了5.78%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了5.63%的用户
     */
    public static int[] plusOne2(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < digits.length; x++) {
            sb.append(digits[x]);
        }
        BigInteger sum = new BigInteger(sb.toString());
        sum = sum.add(new BigInteger("1"));
        String[] temp = sum.toString().split("");
        int[] result = new int[temp.length];
        for (int x = 0; x < result.length; x++) {
            result[x] = Integer.valueOf(temp[x]);
        }
            return result;
        }


        public static void main (String[]args){
            int[] a = plusOne2(new int[]{9,8,7,6,5,4,3,2,1,0});
            for (int x = 0; x < a.length; x++) {
                System.out.print(a[x] + " ");
            }
            // System.out.println(Integer.MAX_VALUE);
        }
    }
