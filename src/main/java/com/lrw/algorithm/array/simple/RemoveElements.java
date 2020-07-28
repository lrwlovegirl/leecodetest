package com.lrw.algorithm.array.simple;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElements {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.68%的用户
     */
    public static int removeElement(int[] nums, int val) {
         int current = 0 ;
         int index =0;
         int len = nums.length;
         if (len==0){
             return 0;
         }
         for (index =0;index<nums.length;index++){
             if (nums[index]==val){
                 for (int x = len-1;x>index;x--){
                     if (nums[x]!=val){
                         int temp = nums[index];
                         nums[index] = nums[x];
                         nums[x] = temp;
                         current++;
                         break;
                     }
                 }
             }else {
                 current++;
             }

         }
         return current;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(removeElement(nums,1));


    }
}
