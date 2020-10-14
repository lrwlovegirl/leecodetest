package com.lrw.algorithm.link.simple;

import com.lrw.algorithm.link.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * Author liurenwang
 * time: 2020-10-9
 */
public class HasCycleLink {
    public static boolean hasCycle(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //龟兔赛跑问题，如果有环，那么一直循环下去，快的会比慢的多跑一圈
    //双指针
    public static boolean hasCycle1(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) { //如果没有相遇，就一直跑下去
            //如果快的到头了，就说明没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode v1 = new ListNode(2);
        ListNode v2 = new ListNode(0);
        ListNode v3 = new ListNode(3);
        head.next = v1;
        v1.next = v2;
        v2.next = v3;
        v3.next = head;
        System.out.println(hasCycle1(head));
    }
}
