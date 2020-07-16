package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tree {
    int val;
    Tree left;
    Tree right;

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }
}


public class Test {
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


    public static void test(TreeNode node){
        //第一层
        if (node==null) return;
        List resultList = new ArrayList();

        List<TreeNode> treeNodes  = new ArrayList<>();
        resultList.add(node.val);

    }


    public static void main(String[] args) {
        Tree v0 = new Tree();
        v0.setVal(3);
        Tree v1 = new Tree();
        v1.setVal(9);
        Tree v2 = new Tree();
        v2.setVal(20);
        Tree v3 = new Tree();
        v3.setVal(15);
        Tree v4 = new Tree();
        v4.setVal(7);
        v0.setLeft(v1);
        v0.setRight(v2);
        v2.setLeft(v3);
        v2.setRight(v4);



    }

}
