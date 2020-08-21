package com.lrw.algorithm.array.middle;

import java.io.File;
import java.util.HashMap;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 这和银行基金那道题一模一样，就是找子串最大值
 */
public class MaxSubArray {
    //暴力解法：穷举所有的子串，然后计算合，时间复杂度 立方级别，会超时
    public int maxSubArray1(int[] nums) {
        return 0;
    }

    /**
     * 1.假如全是负数，那就是找最大值即可，因为负数肯定越加越大。
     * 2.如果有正数，则肯定从正数开始计算和，不然前面有负值，和肯定变小了，所以从正数开始。
     * 3.当和小于零时，这个区间就告一段落了，然后从下一个正数重新开始计算(也就是又回到 2 了)。
     * @param nums
     * @return
     */
    //[-2,1,-3,4,-1,2,1,-5,4],
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];  //asn 永远保持最大的值
        int sum = 0;
        for (int x = 0 ;x<nums.length;x++){
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
        int[]  nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
}
