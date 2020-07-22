package com.lrw.algorithm;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class searchInsertTarget {
    //暴力方式，直接遍历
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return 0;
        if (target > nums[length - 1]) return length;
        if (target < nums[0]) return 0;
        for (int x = 0; x < length - 1; x++) {
            if (nums[x] == target) {
                return x;
            } else if (nums[x + 1] >= target) {
                return x + 1;
            }
        }
        return 0;
    }

    //二分法
    public static int searchInsert1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return 0;
        if (target > nums[length - 1]) return length;
        if (target < nums[0]) return 0;
        // 1 2 5 6  2
        int low = 0;
        while (low <= length) {
            int mid = (low + length) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid;
            } else if (target < nums[mid]) {
                length = mid;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(test, 0));
    }
}




















