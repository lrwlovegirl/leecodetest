package com.lrw.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

//二叉树中序遍历
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        zhongxuHelper(root,result);
        return result;
    }
    //中序遍历： 左 中  右
    private static void zhongxuHelper(TreeNode root,List<Integer> res){
        if (root!=null){
            zhongxuHelper(root.left,res);
            res.add(root.val);
            zhongxuHelper(root.right,res);
        }
    }
    //迭代算法





    public static void main(String[] args) {
        TreeNode v1 = new TreeNode(1);
        TreeNode v2 = new TreeNode(2);
        TreeNode v3 = new TreeNode(3);
        v1.left = v2;
        v1.right = v3;
        List<Integer> list = inorderTraversal(v1);
        for (int x = 0;x<list.size();x++){
            System.out.println(list.get(x));
        }

    }


}
