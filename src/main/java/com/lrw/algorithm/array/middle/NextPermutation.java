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
    //这道题并不是和邻近的换，而是先找一个较大的数，然后找一个较小的数进行交换，至于后面的，要进行升序排序
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        boolean flag = true;
        int i =nums.length-1 ;
        int j = 0;
        while (i > 0){
            if (nums[i]>nums[i-1]){
                flag = false;
                j = i-1;
                break;
            }
            i--;
        }
        if (flag){
            Arrays.sort(nums);
            return;
        }
        swap(nums,i,j);
        //让j 这边的数进行升序
        up(nums,j);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        for (int x = 0; x < nums.length; x++) {
            System.out.print(nums[x] + " ");
        }
    }

    public static void swap(int[] nums ,int i ,int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j] = temp;
    }

    public static void up(int[] nums ,int j){
        int right = nums.length -1;
        while (j<right){
            swap(nums,j,right);
            j++;
            right--;
        }
    }
}
