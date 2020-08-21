package com.lrw.algorithm.array.simple;

import java.util.*;

/**
 * 剑指offer 第三题
 * 找出数组中重复的数字
 * 描述: 在一个长度为n的数组里，所有的数字都在0-(n-1)范围内，数组种某些数子是重复的
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组种任意一个重复的数字，
 * 例如 {2,3,1,0,2,5,3} 输出为2或者3
 * Author liurenwang
 * time 2020-8-17
 */
public class RepeateNumInArray {
    //解法1 ： 排序，遍历 O(NLogN)
    public static List<Integer> method1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;
        //排序
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int x = 1; x < nums.length; x++) {
            if (nums[x] == nums[x - 1]) {
                result.add(nums[x]);
            }
        }
        return result;
    }
    //解法2： 借助hash表，时间复杂度 O(n)
    public static List<Integer> method2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;
        //辅助hash表
        Map<Integer, Integer> map = new HashMap<>();
        //结果集
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < nums.length; x++) {
            if (map.get(nums[x]) == null) {
                map.put(nums[x], nums[x]);
            } else {
                list.add(nums[x]);
            }
        }
        return list;
    }
    //解法3 ： 通读题目，既然数字都在0-(n-1)之间，交换顺序就可以了
    public static List<Integer> method3(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return null;
        //结果集
        List<Integer> list = new ArrayList<>();
        for (int x=0;x<nums.length;x++){
            if (nums[x]==x){
                continue;
            }else {
                if (nums[x]==nums[nums[x]]){
                    list.add(nums[x]);
                }
                int swap = nums[x];
                int swap2 = nums[nums[x]];
                nums[x]   = swap2;
                nums[swap] = swap;
            }
        }
        return list;
    }

    /**
     * 进阶版，不修改数组，找出重复数字
     * 方法1 ， 借助HashMap 遍历
     * 方法2 ， 类似于二分法
     * @param arr
     */
    public static List<Integer> findRepeateNumsWithoutModify(int[] arr){

         return  null;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        List resylt = method3(nums);
        for (int x = 0; x < resylt.size(); x++) {
            System.out.println(resylt.get(x));
        }
    }

}
