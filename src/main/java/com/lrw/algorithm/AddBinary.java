package com.lrw.algorithm;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * https://leetcode-cn.com/problems/add-binary/
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class AddBinary {
    //十进制转2进制，除k取余法 倒取
    //2进制转十进制，乘以进制

    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了7.13%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了7.69%的用户
     */
    public static String addBinary(String a, String b) {
        //进位
        int carry = 0;
        String[] atemp = a.split("");
        String[] btemp = b.split("");
        StringBuilder sb = new StringBuilder();
        int alen = atemp.length - 1;
        int blen = btemp.length - 1;
        for (; alen >= 0 || blen >= 0 || carry == 1; alen--, blen--) {
            int amid = 0, bmid = 0;
            if (alen >= 0) {
                amid = Integer.valueOf(atemp[alen]);
            }
            if (blen >= 0) {
                bmid = Integer.valueOf(btemp[blen]);
            }
            int mid = amid + bmid + carry;
            carry = 0;
            if (mid >= 2) {
                carry = 1;
                mid = mid - 2;
            }
            sb.append(mid);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
    }
}
