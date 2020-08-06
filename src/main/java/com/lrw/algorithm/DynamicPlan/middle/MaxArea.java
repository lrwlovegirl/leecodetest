package com.lrw.algorithm.DynamicPlan.middle;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i
 * 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * https://leetcode-cn.com/problems/container-with-most-water/
 * Author : liurenwang
 * time : 2020-8-6
 */
public class MaxArea {
    /**
     * 暴力破解O(n^2)
     * 执行用时：504 ms, 在所有 Java 提交中击败了11.12%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了49.47%的用户
     */
    public static int maxArea1(int[] height) {
        int result = 0;
        for (int i = 0 ;i<height.length;i++){
            if (height[i]==0){
                continue;
            }
            for (int j =i+1 ;j<height.length;j++){
                if (height[j]==0){
                    continue;
                }
                //低边
                int min = Math.min(height[i], height[j]);
                result = result<(j-i)*min?(j-i)*min:result;
            }
        }
        return result;
    }

   //双指针，看到数组就要想其双指针来！!!!
    public static int maxArea2(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length-1;
        while (i!=j){
            int val = (j-i)*Math.min(height[i],height[j]);
            result = result<=val?val:result;
            if (height[i]<=height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] test = new int[]{1,1};
        System.out.println(maxArea2(test));
    }
}
