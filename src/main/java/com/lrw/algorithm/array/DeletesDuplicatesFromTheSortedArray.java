package com.lrw.algorithm.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeletesDuplicatesFromTheSortedArray {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.81%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了5.74%的用户
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int current = 0;    // 慢指针，在当前指针以及左边的元素是已确定的元素
        int index=0;      // 快指针，用于遍历未确定的元素
        int len = nums.length;
        for ( index=0;index<len;index++){
            if (nums[index]!=nums[current]){
                current++;
                nums[current] = nums[index];
            }
        }
        return  current+1;
    }

}
