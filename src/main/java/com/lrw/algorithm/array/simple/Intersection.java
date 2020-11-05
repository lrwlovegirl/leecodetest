package com.lrw.algorithm.array.simple;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Desc: 给定两个数组，编写一个函数来计算它们的交集。 https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * Author: liurenwang
 * time: 14:02 2020/11/2
 */

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length + nums2.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (index == 0 ||nums1[index1] != result[index - 1]) {
                    result[index] = nums1[index1];
                    index++;
                }
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {

        return Arrays.stream(nums2).filter(t ->   Arrays.stream(nums1).boxed().collect(Collectors.toSet()).contains(t)).distinct().toArray();

    }



}
