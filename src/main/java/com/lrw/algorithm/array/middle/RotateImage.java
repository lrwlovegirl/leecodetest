package com.lrw.algorithm.array.middle;

/**
 * 字节跳动，滴滴 原题
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *  数字   原位置   现位置
 *   1     （0，0） （0，n-1）
 *   2     （0，n-2） (n-2,n-1)
 *   3      (0,n-1)  (n-1,n-1)
 *
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 链接：https://leetcode-cn.com/problems/rotate-image
 */
public class RotateImage {
    /**
     *  * 给定 matrix =
     *  * [
     *  * [1,2,3],
     *  * [4,5,6],
     *  * [7,8,9]
     *  * ],
     *  *  数字   原位置   现位置
     *  *   1     （0，0） （0，n-1）
     *  *   2     （0，n-2） (n-2,n-1)
     *  *   3      (0,n-1)  (n-1,n-1)
     *  *
     * @param matrix
     */

    public static void rotate(int[][] matrix) {
        int temp;
        for (int x = 0, y = matrix[0].length - 1; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(nums);
        for (int x = 0; x < nums.length; x++) {
            int[] array = nums[x];
            for (int y = 0; y < array.length; y++) {
                System.out.print(array[y] + " ");
            }
            System.out.println();
        }
    }


}
