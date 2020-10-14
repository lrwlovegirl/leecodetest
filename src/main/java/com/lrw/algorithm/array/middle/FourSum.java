package com.lrw.algorithm.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先给数组排序
        Arrays.sort(nums);
        //数组为null 或者第一个元素都比目标值大
        if (nums==null||nums[0]>target){
            return null;
        }
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0;x<nums.length;x++){
            //定住第一个，让后三个动
            int first = nums[x];
            //防止重复
            if (x>0&&nums[x]==nums[x-1]){
                continue;
            }
            int last = nums[nums.length-1];



        }

        return result;
    }
}
