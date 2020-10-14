package com.lrw.algorithm.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * https://leetcode-cn.com/problems/3sum/
 * Author: liurenwang
 * time  : 2020-8-6
 */
public class ThreeNumSum {
    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了94.55%的用户
     * 内存消耗：44 MB, 在所有 Java 提交中击败了27.42%的用户
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length <= 2) {
            return list;
        }
        Arrays.sort(nums);//排序
        for (int x = 0; x < nums.length; x++) {
            //如果第一个值就大于0，那么没有符合要求的
            if (nums[x] > 0) {
                break;
            }
            //如果与前面的值重复了，那么就跳过
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            // -1,-1,0, 1, 2
            int target = -nums[x];
            //双指针
            int left = x + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (target == nums[left] + nums[right]) {
                    List<Integer> middleTest = new ArrayList<>();
                    middleTest.add(nums[x]);
                    middleTest.add(nums[left]);
                    middleTest.add(nums[right]);
                    list.add(middleTest);
                    left++;
                    right--;
                    //防止新元素与前面的重复
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right +1]) {
                        right--;
                    }
                }else if (target>nums[left] + nums[right]){//和小
                    left++;
                }
                else if (target<nums[left] + nums[right]){//和大
                    right--;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1,};
        List<List<Integer>> list = threeSum(nums);
        for (int x = 0; x < list.size(); x++) {
            List<Integer> vo = list.get(x);
            for (int y = 0; y < vo.size(); y++) {
                System.out.print(vo.get(y) + ",");
            }
            System.out.println();
        }
    }
}
