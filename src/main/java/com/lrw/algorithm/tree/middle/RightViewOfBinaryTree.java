package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }

    public void  dfs(TreeNode root,int depth,List<Integer> res){
        if (root==null){
            return;
        }
        if (depth==res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth,res);
        dfs(root.left,depth,res);
    }



}
