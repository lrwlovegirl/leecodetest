package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RightViewOfBinaryTree {
    //此方法行不通  输入：[1,null,2,null,5,4,6,3]  正确答案：[1,2,5,6,3]  代码输出：[1,2,5,6]
    public static List<Integer> rightSideView(TreeNode root) {
        //校验空
        List<Integer> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }

        //校验只有根节点
        if (root.right == null && root.left == null) {
            resultList.add(root.val);
            return resultList;
        }
        //正常来讲，在同一级上，只要有右节点就看不到其他的子节点
        int rightCount = 1; //计数器看一下到第几层右节点没有子节点了
        int leftCount = 1; //左节点计数器
        TreeNode copyRoot = root;
        resultList.add(root.val);
        while (root.right != null || root.left != null) {
            rightCount++;
            if (root.right != null) {
                resultList.add(root.right.val);
                root = root.right;
            } else if (root.left != null) {
                resultList.add(root.left.val);
                root = root.left;
            }
        }

        while (copyRoot!=null&&(copyRoot.left != null || copyRoot.right != null)) {
            leftCount++;
            if (leftCount > rightCount) {
                if (copyRoot.right != null) {
                    resultList.add(copyRoot.right.val);
                    copyRoot = copyRoot.right;
                } else if (copyRoot.left != null) {
                    resultList.add(copyRoot.left.val);
                    copyRoot = copyRoot.left;
                }
            } else {
                if (leftCount - 1 == 1) {
                    copyRoot = copyRoot.left;
                } else {
                    if (copyRoot.right != null) {
                        copyRoot = copyRoot.right;
                    } else if (copyRoot.left != null) {
                        copyRoot = copyRoot.left;
                    }
                }
            }
        }
        return resultList;
    }



    public static List<Integer> rightSideView1(TreeNode root) {
        //校验空
        List<Integer> resultList = new ArrayList<>();
        if (null == root) {
            return resultList;
        }
        //校验只有根节点
        if (root.right == null && root.left == null) {
            resultList.add(root.val);
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size(); // 每层节点的数量
            for (int x = 0 ;x<size;x++){
                TreeNode node = queue.poll();//出队


            }
        }

        return resultList;
    }


    public static void main(String[] args) {
//        TreeNode t1  = new TreeNode(1);
//        TreeNode t2  = new TreeNode(2);
//        TreeNode t3  = new TreeNode(3);
//        TreeNode t4  = new TreeNode(4);
//        TreeNode t5  = new TreeNode(5);
//        t2.right= t5;
//        t3.right = t4;
//        t1.left = t2;
//        t1.right = t3;
//        List<Integer> list = rightSideView(t1);
//        list.forEach(obj->{
//            System.out.println(obj);
//       });
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        t2.left = t4;
//        t1.left = t2;
//        t1.right = t3;
//        List<Integer> list = rightSideView(t1);
//        list.forEach(obj -> {
//            System.out.println(obj);
//        });

        TreeNode t1  = new TreeNode(1);
        TreeNode t3  = new TreeNode(3);
        t1.right=t3;
        List<Integer> list = rightSideView(t1);
        list.forEach(obj->{
            System.out.println(obj);
        });
    }

}
