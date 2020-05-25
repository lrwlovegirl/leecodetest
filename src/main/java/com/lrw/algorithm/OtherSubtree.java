package com.lrw.algorithm;
/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \  / \
 * 1   2 n  n
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class OtherSubtree {


    /**
     * 未通过，原因：只包含不行，s树对应的子树不能比t树节点多
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> sList = converToList(s);
        List<Integer> tList = converToList(t);
        // return sList.containsAll(tList);
        List<Integer> indexList = converToList(t);
        if (sList.containsAll(tList)) {

        }
        return false;
    }

    public static List<Integer> converToList(TreeNode s) {
        List<Integer> sList = new ArrayList<>();
        boolean flag = true;
        while (s != null) {
            if (flag) {
                sList.add(s.val);
                flag = false;
            }
            if (s.left != null) {
                sList.add(s.left.val);
            }
            if (s.right != null) {
                sList.add(s.right.val);
            }
            if (s.left != null) {
                s = s.left;
            } else {
                s = s.right;
            }
        }
        return sList;
    }

    //########################################################################################################
    public static boolean isSubtree1(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree1(s.left, t) || isSubtree1(s.right, t) || isSameTree(s,t);
    }

    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        t4.left = t1;
//        t4.right = t2;
//        t3.left = t4;
//        t3.right = t5;
//        System.out.println(isSubtree1(t3, t4));
        char a = 256;
        int d = a;

    }
}

