package com.lrw.algorithm.array.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute_46 {


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums,0,list,used,result);
        return result;
    }

    private static void dfs(int[] nums,int depth,List<Integer> list,boolean[] used,List<List<Integer>> result){
        if (nums.length == depth){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(nums,depth+1,list,used,result);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(JSON.toJSON(permute(nums)));
    }


    private static void  bfs(int[] nums, int size ,List<Integer> list, Map<Integer,Boolean> usedMap,List<List<Integer>> res){
        if (nums.length == size){
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
        }

    }

}
