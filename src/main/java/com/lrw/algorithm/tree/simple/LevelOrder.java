package com.lrw.algorithm.tree.simple;

import com.lrw.algorithm.tree.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 * Author: liurenwang
 * time : 2020/11/20 20:14
 */
public class LevelOrder {

    public static void levelOrder(TreeNode root){
        if (root==null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        TreeNode curr;
        list.add(root);
        while (!list.isEmpty()){
            curr = list.remove(list.size()-1);
            if (curr.left!=null){
                list.add(curr.left);
            }
            if (curr.right!=null){
                list.add(curr.right);
            }
        }
    }
}
