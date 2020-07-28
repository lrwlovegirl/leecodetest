package com.lrw.algorithm.number.simple;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        for (int x=0;x<nums.length;x++){
            int num = nums[x];
            int diff = target-num;
            for (int y=x+1;y<nums.length;y++){
                if (diff==nums[y]){
                    return new int[]{x,y};
                }
            }
        }
        return  null;
    }

}
