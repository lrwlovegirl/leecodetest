package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 */
public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new LinkedList<>();
        //总体思路是将N分成3堆， 左  中  右
        if (N % 2 == 0) {
            return result;
        }
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            result.add(node);
            return result;
        }
        for (int i = 1; i < N; i = i + 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            left.forEach(leftNode -> {
                right.forEach(rightNode -> {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                });
            });
        }
        return result;
    }

}
