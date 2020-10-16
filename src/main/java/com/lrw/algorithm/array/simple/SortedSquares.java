package com.lrw.algorithm.array.simple;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        for (int x = 0; x < A.length; x++) {
            A[x] = A[x]*A[x];
        }
        Arrays.sort(A);
        return A;
    }
    //看到数组，链表，就应该想到双指针的
}
