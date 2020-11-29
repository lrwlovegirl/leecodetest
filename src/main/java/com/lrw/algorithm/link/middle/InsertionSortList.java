package com.lrw.algorithm.link.middle;

import com.lrw.algorithm.link.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * desc:  147. 对链表进行插入排序  https://leetcode-cn.com/problems/insertion-sort-list/
 * Author: liurenwang
 * time : 2020/11/20 14:54
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode resultHead = new ListNode();
        resultHead.next = head;
        ListNode lastSortNode =head;
        ListNode curr = head.next;
        while (curr!=null){
            if (lastSortNode.val<=curr.val){
                lastSortNode = lastSortNode.next;
            }else {
                ListNode prev = resultHead;
                while (prev.next.val<curr.val){
                    prev = prev.next;
                }
                lastSortNode .next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSortNode.next;
        }
        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode v0 = new ListNode(4);
        ListNode v1 = new ListNode(2);
        ListNode v2 = new ListNode(1);
        ListNode v3 = new ListNode(3);
        v0.next = v1;
        v1.next = v2;
        v2.next = v3;
        ListNode node = insertionSortList(v0);
        while (node !=null){
            System.out.print(node.val+" ");
            node = node.next;
        }


    }

}
