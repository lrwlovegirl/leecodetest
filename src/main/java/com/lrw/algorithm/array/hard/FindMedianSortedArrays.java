package com.lrw.algorithm.array.hard;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        for (int x = 0; x < nums1.length; x++) {
            result[x] = nums1[x];
        }
        for (int y = nums1.length, x = 0; y < nums1.length + nums2.length; y++, x++) {
            result[y] = nums2[x];
        }
        Arrays.sort(result);
        if (result.length%2==0){
            return ((double) result[result.length/2]+(double) result[result.length/2-1])/2;
        }else {
            return result[result.length/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
