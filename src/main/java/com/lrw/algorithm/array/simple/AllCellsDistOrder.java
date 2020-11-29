package com.lrw.algorithm.array.simple;

import java.util.Arrays;
import java.util.Comparator;

/**
 * desc: 1030. 距离顺序排列矩阵单元格  https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * Author: liurenwang
 * time : 2020/11/17 14:42
 */
public class AllCellsDistOrder {

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(result, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = allCellsDistOrder(2, 3, 1, 2);
        for (int[] s : ints) {
            for (int x : s) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
