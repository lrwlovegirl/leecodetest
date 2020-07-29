package com.lrw.algorithm.DynamicPlan.middle;

import java.math.BigInteger;

/**
 * 62 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author liurenwang
 * time 2020-7-29
 */
public class DifferentPath {
    /**
     * 思路：从左上角走到右下角一共需要向右走m-1，向下走n-1步， 一共走m+n-2步，
     * 其中m-1步是向右的，所以是个排列组合问题
     * 执行用时：5 ms
     * 内存消耗：37.6 MB
     */
    public static int uniquePaths(int m, int n) {
        int bootom = m + n - 2;
        int up = m - 1;
        return Integer.valueOf(Integer.parseInt(String.valueOf(((factorial((bootom)).divide(factorial(bootom - up))).divide(factorial(up))))));
    }
    //阶乘计算,13的阶乘就已经溢出int范围了
    public static BigInteger factorial(int n) {
        if (n == 1||n==0) return new BigInteger("1");
        return factorial(n-1).multiply(new BigInteger(String.valueOf(n)));
    }
    //#################################################################################
    //动态规划解法，参考视频：https://www.bilibili.com/video/BV1xb411e7ww?from=search&seid=15646414550319269409

    /**
     执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     内存消耗：36.7 MB, 在所有 Java 提交中击败了6.35%的用户
     */
    public static int uniquePaths2(int m,int n){
        int[][] nums = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0||j==0){  //定义边界
                    nums[i][j]=1;
                }else {
                    nums[i][j] = nums[i][j-1]+nums[i-1][j];//转换方程
                }
            }
        }
        return nums[m-1][n-1];
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 3));
    }

}
