package com.lrw.algorithm.array.middle;

/**
 * Desc: 1395. 统计作战单位数
 * https://leetcode-cn.com/problems/count-number-of-teams/
 * Author: liurenwang
 * time: 17:26 2020/11/3
 */
public class NumTeams {

    public static int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int sum = 0;
        for (int x = 0; x < rating.length; x++) {
            int first = rating[x];
            for (int y = x + 1; y < rating.length; y++) {
                int second = rating[y];
                for (int z = y + 1; z < rating.length; z++) {
                    int third = rating[z];
                    if ((first < second && second < third) || (first > second && second > third)) {
                        sum++;
                    }
                }

            }
        }
        return sum;
    }

    //枚举中间点
    public static int numTeams1(int[] rating) {
        if (rating==null||rating.length < 3) {
            return 0;
        }
        int sum = 0;
        for (int x = 1; x < rating.length; x++) {
            int middle = rating[x];
            int leftLess = 0;
            int leftMore = 0;
            int rightLess = 0;
            int rightMore = 0;
            for (int y = 0; y < x; y++) {
                if (rating[y] < middle) {
                    leftLess++;
                } else {//因为题目说了是独一无二的，所以直接else
                    leftMore++;
                }
            }
            for (int z = x + 1; z < rating.length; z++) {
                if (rating[z] > middle) {
                    rightMore++;
                }else {
                    rightLess++;
                }
            }
            sum = sum+ leftLess*rightMore+leftMore*rightLess;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numTeams1(new int[]{2, 5, 3, 4, 1}));
        System.out.println(numTeams1(new int[]{2, 1, 3}));
        System.out.println(numTeams1(new int[]{1, 2, 3, 4}));

    }
}
