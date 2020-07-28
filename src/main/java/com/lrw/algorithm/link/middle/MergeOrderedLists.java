package com.lrw.algorithm.link.middle;


import com.lrw.algorithm.link.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MergeOrderedLists {
    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了65.72%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了63.55%的用户
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null) return l1;
        List<Integer> l1List = new LinkedList<>();
        List<Integer> l2List = new LinkedList<>();
        while (l1!=null){
            l1List.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            l2List.add(l2.val);
            l2 = l2.next;
        }
        l1List.addAll(l2List);
        l1List.sort(Integer::compareTo);
        ListNode head = new ListNode(0);
        ListNode copyHead = head;
        for (int x=0;x<l1List.size();x++){
            ListNode vo = new ListNode(l1List.get(x));
            while (head.next!=null){
                head = head.next;
            }
            head .next = vo ;
        }
        return copyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;

        ListNode result = mergeTwoLists(l1,l4);
        while (result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
