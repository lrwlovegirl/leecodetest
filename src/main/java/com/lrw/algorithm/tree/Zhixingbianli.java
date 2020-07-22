
package com.lrw.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树之字形遍历
 */
public class Zhixingbianli {
    private List<Integer> resultList = new ArrayList<>();
    private static int level = 1;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    private static void helper(TreeNode node, List<List<Integer>> ans, int level) {
        if (node == null) return;
        if (ans.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            ans.add(newLevel);
        }
        List<Integer> collection = ans.get(level);
        if (level % 2 == 0) {
            collection.add(node.val);
        } else {
            collection.add(0, node.val);
        }
        helper(node.left, ans, level + 1);
        helper(node.right, ans, level + 1);
    }

    public static void test(TreeNode node) {
        //第一层
        if (node == null) return;
        List resultList = new ArrayList();
        List<TreeNode> treeNodes = new ArrayList<>();
        resultList.add(node.val);
    }

    public static void main(String[] args) {

    }
}
