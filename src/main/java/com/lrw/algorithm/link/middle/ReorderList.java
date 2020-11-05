package com.lrw.algorithm.link.middle;

import com.lrw.algorithm.link.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 链接：https://leetcode-cn.com/problems/reorder-list
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i =0;
        int j = list.size()-1;
        while (i<j){
            list.get(i).next = list.get(j);
            i++;
            if (i==j){
                break;
            }
            list.get(j).next =list.get(i);
            j--;
        }
        list.get(i).next =null;
    }
}
