package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class RightViewOfBinaryTree {

    public static List<Integer> rightSideView(TreeNode root) {
        //校验空
        if (null==root){return null;}
        List<Integer> resultList = new ArrayList<>();
        //校验只有根节点，没有右子节点
        if (root.right==null){
            resultList.add(root.val);
            return resultList;
        }

        while (root!=null){
            resultList.add(root.val);
            if (root.right!=null){
                root = root.right;
            }else{
                if (root.left!=null){
                    root = root.left;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {


    }

}
