package com.lrw.algorithm.tree.simple;

import com.lrw.algorithm.tree.TreeNode;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSameTree {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了90.48%的用户
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p==null&&q!=null)||(p!=null&&q==null)){
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(3);
        p.left = p1;
        p.right = p2;
        q.left = q1;
        q.right = q2;
        System.out.println(isSameTree(p, q));


    }
}
