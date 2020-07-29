package com.lrw.algorithm.link.simple;

import com.lrw.algorithm.link.ListNode;

import java.util.Stack;

/**
 * 反转链表
 * 1->2->3->4->5->null
 * 5->4->3->2->1->null
 */
public class ReverseLink {
    //2种方法，一种是借助栈，先进后出，不过空间复杂度会高
    //第二种是直接调换指针的方向
    public static ListNode reverseLink(ListNode root){
        //最基础的情况
        if (root==null||root.next==null){
            return root;
        }
        ListNode newHead = reverseLink(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }
    //借助栈
    public static ListNode reverseLinkWithStack(ListNode root){
        //最基础的情况
        if (root==null||root.next==null){
            return root;
        }
        Stack<Integer> stack = new Stack<>();
        while (root!=null){
            stack.push(root.val);
            root = root.next;
        }
        ListNode head = new ListNode(0);
        ListNode resultHead = head;
        while (!stack.isEmpty()){
            //peek 不会使元素出栈
            ListNode vo = new ListNode(stack.pop());
            head.next = vo;
            head = head.next;
        }
        return resultHead.next;
    }





    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode v1 = new ListNode(2);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(4);
        ListNode v4 = new ListNode(5);
        root.next  =v1;
        v1.next = v2;
        v2.next = v3;
        v3.next =v4;

        ListNode newRoot = reverseLinkWithStack(root);
        while (newRoot!=null){
            System.out.println(newRoot.val);
            newRoot = newRoot.next;
        }
    }

}
