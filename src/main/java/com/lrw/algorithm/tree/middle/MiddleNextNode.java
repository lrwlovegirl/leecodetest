package com.lrw.algorithm.tree.middle;

/**
 * 剑指offer第8题，
 * 给定一棵二叉树，和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有2个分别指向左右节点的指针，还有一个指向父节点的指针
 */
public class MiddleNextNode {
    static class Node {
        String val;
        Node left;
        Node right;
        Node parent;

        public Node(String val) {
            this.val = val;
        }
    }

    public static String resolve(Node node) {
        if (node == null) {
            return null;
        }
        //1. 如果节点有右节点，那么他的下一个节点是右节点的最左节点
        if (node.right != null) {
            Node result = node.right;
            while (result.left != null) {
                result = result.left;
            }
            return result.val;
        }
        //2 . 如果节点没有右节点，且他是左节点，则他的下一个节点为他的父节点
        if (node.right == null && node.equals(node.parent.left)) {
            return node.parent.val;
        }
        //3 . 如果节点没有右节点，且是右节点，那么他的下一个节点是父节点是左节点的节点
        if (node.right == null && node.equals(node.parent.right)) {
            try {
                while (node.parent != null) {
                    if (node.parent.equals(node.parent.parent.left)) {
                        return node.parent.parent.val;
                    } else {
                        node.parent = node.parent.parent;
                    }
                }
            }catch (NullPointerException e){
                System.out.println("没有下一个节点");
                return "";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node i = new Node("i");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        b.parent = a;
        c.left = f;
        c.right = g;
        c.parent = a;
        d.parent = b;
        e.left = h;
        e.right = i;
        e.parent = b;
        f.parent = c;
        g.parent = c;
        h.parent = e;
        i.parent = e;
        System.out.println(resolve(g));


    }

}
