package com.lrw.algorithm.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: 面试题 08.04. 幂集 https://leetcode-cn.com/problems/power-set-lcci/
 * Author: liurenwang
 * time: 18:25 2020/11/3
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        //先添加一个空的集合
        res.add(new ArrayList<>());
        for (int num : nums) {
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int i = 0, j = res.size(); i < j; i++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> list = new ArrayList<>(res.get(i));
                //然后在新的子集后面追加这个元素
                list.add(num);
                //把这个新的子集添加到集合中
                res.add(list);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        subsets.forEach(list -> {
            list.forEach(a->{
                System.out.print(a+" ");
            });
            System.out.println();
        });
    }


}
