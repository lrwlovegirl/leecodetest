package com.lrw.algorithm.link.middle;

import com.lrw.algorithm.link.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class MiddleHasCircleLink {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (!fast.equals(slow)) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode v1 = new ListNode(2);
        ListNode v2 = new ListNode(0);
        ListNode v3 = new ListNode(4);
        head.next = v1;
        v1.next = v2;
        v2.next = v3;
        v3.next = head;
        System.out.println(detectCycle1(head));
    }

}
