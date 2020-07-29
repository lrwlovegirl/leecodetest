package com.lrw.algorithm.DynamicPlan.simple;

/**
 * 有N个台阶，每次能上1阶或2阶，问有多少种算法
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class UpToStep {

    public static int upToStep(int n){
        //开数组
        int[] nums = new int[n];
        //定义边界
        nums[0] =1 ;
        if (n>=2){
            nums[1] = 2;
        }
        //转换方程
        for (int i=2;i<n;i++){
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        System.out.println(upToStep(1));
    }

}
