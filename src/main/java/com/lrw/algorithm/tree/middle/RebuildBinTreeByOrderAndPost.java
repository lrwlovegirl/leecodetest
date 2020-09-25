package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;
import com.lrw.algorithm.tree.simple.InorderTraversal;

import java.util.Arrays;
import java.util.List;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class RebuildBinTreeByOrderAndPost {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序遍历的最后一个节点是根节点
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        //查询到后续遍历在中序的位置
        int position = -1;
        for (int x = 0; x < inorder.length; x++) {
            if (val == inorder[x]) {
                position = x;
                break;
            }
        }
        //中序左子树
        int[] preInorder = Arrays.copyOfRange(inorder, 0, position );
        //中序右子树
        int[] postInorder = Arrays.copyOfRange(inorder, position + 1, inorder.length);
        // 后序的左子树
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, preInorder.length );
        //后序的右子树
        int[] rightPostOrder = Arrays.copyOfRange(postorder, preInorder.length , postorder.length - 1);
        root.left = buildTree(preInorder, leftPostOrder);
        root.right = buildTree(postInorder, rightPostOrder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        List<Integer> inorderTraversal = InorderTraversal.inorderTraversal(buildTree(inorder, postorder));
        for (int x = 0; x < inorderTraversal.size(); x++) {
            System.out.println(inorderTraversal.get(x));
        }
    }
}
