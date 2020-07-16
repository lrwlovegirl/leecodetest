package com.lrw.algorithm;

/**
 *
 * <p>
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *   1
 *  / \
 * 2   2
 * / \ / \
 * 3  2 4  3
 *
 *
 */
public class SymmetryTree {
    /**
     *   执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *   内存消耗：38.2 MB, 在所有 Java 提交中击败了11.25%的用户
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameNode(root.left, root.right);
    }

    public static boolean isSameNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val != right.val) {
            return false;
        }
        return isSameNode(left.left, right.right)&& isSameNode(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(4);
        TreeNode l6 = new TreeNode(3);
        root.left = l1;
        root.right = l2;
        l1.left = l3;
        l1.right = l4;
        l2.left = l5;
        l2.right = l6;
        System.out.println(isSymmetric(root));
    }
}
