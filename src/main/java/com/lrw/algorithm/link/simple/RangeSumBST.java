package com.lrw.algorithm.link.simple;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RangeSumBST {

    private static int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> list = middleSort(root,new ArrayList<>());
        int sum =0 ;
        for (int x=0;x<list.size();x++){
            if (list.get(x)>=L&&list.get(x)<=R){
                sum = sum + list.get(x);
            }
        }
        return sum;
    }
    //二叉搜索树中序遍历
    public List<Integer> middleSort(TreeNode root, List<Integer> list) {
        if (root==null){
            return list;
        }
        middleSort(root.left,list);
        list.add(root.val);
        middleSort(root.right,list);
        return list;
    }


    public int rangeSumBST1(TreeNode root, int L, int R) {
        middleSort1(root,L,R);
        return sum;
    }
    public int middleSort1(TreeNode root,int L,int R) {
        if (root==null){
            return sum;
        }
        middleSort1(root.left,L,R);
        if (root.val>=L&&root.val<=R){
            sum+=root.val;
        }
        middleSort1(root.right,L,R);
        return sum;
    }

}
