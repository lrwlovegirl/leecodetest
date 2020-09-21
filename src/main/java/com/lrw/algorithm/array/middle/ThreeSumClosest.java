package com.lrw.algorithm.array.middle;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author liurenwang
 * time 2020-9-17
 */
public class ThreeSumClosest {
    /**
     * nums = [-1,2,1,-4], target = 1
     */
    public static int threeSumClosest(int[] nums, int target) {
        //先给数组排序
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int x = 0;x<nums.length;x++){
            int start = x+1 ,end = nums.length-1;
            while (start<end){
                int sum  = nums[x]+nums[start]+nums[end];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int []nums = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
