package com.lrw.algorithm.array.middle;

import java.util.Arrays;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        boolean flag = false;
        for (int x = nums.length - 1; x>=0; x--) {
           if (x>0&&nums[x]>nums[x-1]){//找到了
               

               flag = true;
               break;
           }
        }
        if (flag){
            Arrays.sort(nums);
        }else {
            return;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        for (int x = 0; x < nums.length; x++) {
            System.out.print(nums[x] + " ");
        }
    }
}
