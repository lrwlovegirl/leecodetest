package com.lrw.algorithm.tree.middle;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 */
public class PerfectNodeConnect {
    //思路就是从上一层给下一层建立next指针
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //从根节点开始
        Node leftMost = root;
        while (leftMost.left != null) {
            //当前层的头节点
            Node head = leftMost;
            //给下一层建立next指针
            while (head!=null){
                //同一个父节点
                head.left.next = head.right;
                //不同父节点，A父节点的右节点  和  B 父节点的左节点
                if (head.next!=null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public static void main(String[] args) {
         Node root = new Node(1);
         connect(root);
    }
}




class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
