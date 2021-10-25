package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 */
public class PathSum_437 {
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int result = 0;

        result = sumNode(root,targetSum);
        result = result + pathSum(root.left,targetSum);
        result = result + pathSum(root.right,targetSum);
        return result;
    }

    public static int sumNode(TreeNode root,int target){
        if (root == null){
            return 0;
        }
        int result = 0;
        if (root.val == target){
            result ++;
        }

        result = result + sumNode(root.left,target-root.val);
        result = result + sumNode(root.right,target-root.val);
        return result;
    }




}
