package com.lrw.algorithm.DynamicPlan.middle;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class DifferentPathPlus {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int num = 0;
         for (int x = 0;x<obstacleGrid.length;x++){
             int[] middle = obstacleGrid[x];
             for (int y =0 ;y<middle.length;y++){
                 if ((x==0||y==0)&&obstacleGrid[x][y]==1){
                     num++;
                 }else if (obstacleGrid[x][y]==1){
                     num = num+2;
                 }
             }
         }
         return num;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(test));
    }
}
