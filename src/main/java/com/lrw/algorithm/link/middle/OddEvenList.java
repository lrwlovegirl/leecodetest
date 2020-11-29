package com.lrw.algorithm.link.middle;

import com.lrw.algorithm.link.ListNode;

/**
 * desc: 328. 奇偶链表  https://leetcode-cn.com/problems/odd-even-linked-list/
 * Author:liurenwang
 * time:2020/11/13 21:20
 */
public class OddEvenList {


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        ListNode node = oddEvenList(v1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

}
