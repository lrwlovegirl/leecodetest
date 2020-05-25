package com.lrw.algorithm;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * https://leetcode-cn.com/problems/search-insert-position/
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class SearchInsert {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了5.55%的用户
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums[0]>=target){
            return 0;
        }
        if (nums[nums.length-1]<target){
            return nums.length;
        }
        for (int x= 0;x<nums.length;x++){
            if (nums[x]<target) {
                continue;
            }
            if (nums[x]>=target){
                return x;
            }
        }
         return  0 ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
        System.gc();
    }
}
