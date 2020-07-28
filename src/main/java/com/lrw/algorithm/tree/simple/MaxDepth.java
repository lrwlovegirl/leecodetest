package com.lrw.algorithm.tree.simple;

import com.lrw.algorithm.tree.TreeNode;

import java.util.*;

/**
 * 104 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *  *https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
    //递归
    public static int maxDepth(TreeNode root) {
       return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //层序遍历bfs（只是单纯的一个层序遍历）
    public static List<Integer> levelTraverse(TreeNode root){
        if (root==null) return null;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);
        while (root!=null){
            if (root.left!=null){
                result.add(root.left.val);
                queue.add(root.left);
            }
            if (root.right!=null){
                result.add(root.right.val);
                queue.add(root.right);
            }
            //节点出队
            queue.poll();
            //更换头节点
            root =  queue.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode v0 = new TreeNode(2);
        TreeNode v1 = new TreeNode(3);
        TreeNode v2 = new TreeNode(4);
        TreeNode v3 = new TreeNode(5);
        TreeNode v4 = new TreeNode(6);
        TreeNode v5 = new TreeNode(7);
        root.left = v0;
        root.right = v1;
        v0.left=v2;
        v0.right = v3;
        v1.left=v4;
        v1.right=v5;
        List<Integer> result = levelTraverse(root);
        for (int x =0 ;x<result.size();x++){
            System.out.println(result.get(x));
        }
    }

}
