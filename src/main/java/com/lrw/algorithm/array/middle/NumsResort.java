package com.lrw.algorithm.array.middle;

import java.util.*;

/**
 * 拼多多笔试
 * 1个有序的数组，里面包含了 N 个数字，分割成 M 段（M<=N），然后进行乱序排列，如何快速恢复其顺序
 * Author :liurenwang
 * time 2020-9-16
 */
public class NumsResort {
    /**
     * 现在有个有序数组，让你拆成M块，然后将顺序打乱，最后再次进行重组
     *
     * @param arr 有序数组
     * @param n   数组长度
     * @param m   要分割的块数
     * @return
     */
    public static int[] resort(int[] arr, int n, int m) {
        //base case
        if (n == 0 || arr == null) {
            return null;
        }
        //不用拆了
        if (m == 1) {
            System.out.println("就一份，拆啥拆");
            return arr;
        }

        //定义返回结果
        int[] result = new int[n];
        //先拆成M块
        //1.计算要拆的，每个数组的平均数
        int count = n / m;
        int index = 0;
        //截取 + 打乱
        Set<int[]> set = new HashSet<>();

        for (int x = 0; x < m ; x++) {
            int[] vo = null;
            if (x == m - 1) {//如果是最后一次
                vo = Arrays.copyOfRange(arr, index , n);
            } else {
                vo = Arrays.copyOfRange(arr, index, index + count);
            }
            set.add(vo);
            index = index + count; //重新设置复制点
        }
        Iterator<int[]> iterator = set.iterator();
        System.out.println("拆的数组：");
        while (iterator.hasNext()){
            int[] next = iterator.next();
            for (int y =0;y<next.length;y++){
                System.out.print(next[y]+"、");
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr =  new int [] {1,2,3,4,5,6,7,8,9,10};
        resort(arr,arr.length,3);
    }
}
