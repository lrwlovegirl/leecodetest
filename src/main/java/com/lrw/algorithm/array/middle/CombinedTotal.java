package com.lrw.algorithm.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinedTotal {
    //https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
    //参考答案，回溯法
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(target, candidates, 0, result, ans);
        return result;
    }

    private static void helper(int target, int[] candidates, int begin, List<List<Integer>> result, List<Integer> ans) {
        //递归出口
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int x = begin; x < candidates.length; x++) {
            ans.add(candidates[x]);
            int v = target - candidates[x];
            helper(v, candidates, x, result, ans);
            //删除最后一个元素
            ans.remove(ans.size() - 1);
        }
    }

    private static void helper1(int target, int[] candidates, int begin, List<List<Integer>> result, List<Integer> ans) {
        //递归出口
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int x = begin; x < candidates.length; x++) {
            if (x>begin&&candidates[x]==candidates[x-1]){
                continue;
            }
            ans.add(candidates[x]);
            int v = target - candidates[x];
            helper1(v, candidates, x + 1, result, ans);
            //删除最后一个元素
            ans.remove(ans.size() - 1);
        }
    }

    /**
     * 进阶版，不能重复
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper1(target, candidates, 0, result, ans);
        return result;
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        lists.forEach(list -> {
            list.forEach(obj -> {
                System.out.print(obj + " ");
            });
            System.out.println(" ");
        });
    }






}
