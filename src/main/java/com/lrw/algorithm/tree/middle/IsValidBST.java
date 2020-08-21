package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public static List<Integer> list = new ArrayList<>();

    public static boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        //最基本的情况都不符合
        if ((root.left!=null&&root.left.val>=root.val)||(root.right!=null&&root.right.val<=root.val)){
            return false;
        }
        //子树满足，但是左节点比根节点小
        //if ()



        return isValidBST(root.left)&&isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(3);
        p.left = p1;
        p.right= p2;
        System.out.println(isValidBST(p));
    }
}
