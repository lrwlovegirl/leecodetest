package com.lrw.algorithm.DynamicPlan.simple;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LargestOfSumSuborders {

    public static int maxSubArray(int[] nums) {
        //base case
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        //other case
        int ans = nums[0];
        int sum = 0;
        //大于0的时候可以尝试加一下，因为你不知道下一个数字是否大于0
        //如果小于0就让ans保持原样，如果大于0就在ans加上
        //如果sum已经小于0了，那么就要舍弃该区间
        for (int x=0; x<nums.length;x++){
         if (sum>0){
             sum = sum+nums[x];
         }else {
             sum = nums[x];
         }
         ans = Math.max(sum,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2};
        System.out.println(maxSubArray(nums));
    }
}
