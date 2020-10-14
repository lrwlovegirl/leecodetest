package com.lrw.algorithm.tree.simple;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDifference {


    //最小值，是相邻节点的差值，而二叉搜索树的中序遍历就是递增序列
    public  int getMinimumDifference(TreeNode root) {
        //两个节点差值最小，那么就是2个节点大小差不多
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        //结果集
        int ans = Integer.MAX_VALUE;
        List<Integer> result = middleSequence(root, list);
        for (int x = 1; x < result.size(); x++) {
            int val = Math.abs(result.get(x) - result.get(x - 1));
            ans = ans < val ? ans : val;
        }
        return ans;
    }

    private  List<Integer> middleSequence(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        middleSequence(root.left, list);
        list.add(root.val);
        middleSequence(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rightNode = new TreeNode(5);
        TreeNode leftNode = new TreeNode(3);
        root.right = rightNode;
        rightNode.left = leftNode;
        System.out.println(new MinimumDifference().getMinimumDifference(root));

    }


}
