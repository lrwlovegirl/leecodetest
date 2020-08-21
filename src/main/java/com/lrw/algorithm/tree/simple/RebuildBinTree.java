package com.lrw.algorithm.tree.simple;

import com.lrw.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 剑指offer第6题，根据前序和中序遍历，构建二叉树
 * Author: liurenwang
 * time: 2020-8-21
 */
public class RebuildBinTree {

    public static TreeNode resolve(int[] front, int middle[]) {
        if (front == null || front.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(front[0]); //根节点
        int index = -1;//根节点在中序遍历中的位置,初始为-1
        for (int x = 0; x < middle.length; x++) {
            if (front[0] == middle[x]) {
                index = x;
                break;
            }
        }
        //先序遍历被分成 2部分(下标): 1 - index  , index+1 - front.length-1;
        //中序遍历被分成 2部分(下标): 0 - index-1  , index+1 - middle.length-1;11
        //先序2部分
        int[] rootFrontLeft = Arrays.copyOfRange(front, 1, index + 1);
        int[] rootFrontRight = Arrays.copyOfRange(front, index + 1, front.length);
        //中序2部分
        int[] rootMiddleLeft = Arrays.copyOfRange(middle, 0, index);
        int[] rootMiddleRight = Arrays.copyOfRange(middle, index + 1, middle.length);
        //构建二叉树
        root.left = resolve(rootFrontLeft, rootMiddleLeft);
        root.right = resolve(rootFrontRight, rootMiddleRight);
        return root;
    }

    public static void main(String[] args) {
        int[] front = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = resolve(front, middle);
        List<Integer> result = InorderTraversal.inorderTraversal(root);
        for (int x = 0; x < result.size(); x++) {
            System.out.println(result.get(x));
        }
    }
}
