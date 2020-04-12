package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class TwoNumAdd {
    /**
     * 第一眼思路：
     * 将每个链表的值转成int ,然后两个int 相加 最后再转成链表 =>结果：未通过，缺陷，因为不int的取值范围很小，链表很容易超过int范围
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int resultl1 = pareseToInt(l1);
        int resultl2 = pareseToInt(l2);
        int result = resultl1 + resultl2;
        String temp = String.valueOf(result);
        int n = temp.length();
        ListNode vo = new ListNode((int) (result / Math.pow(10, 0)) % 10);
        ListNode head = vo;
        for (int i = 1; i < n; i++) {
            vo.next = new ListNode((int) (result / Math.pow(10, i)) % 10);
            vo = vo.next;
        }
        vo = head;
        return vo;
    }
    // 342 =》 2->4->3

    /**
     * 第一种思路不行，就只能每个链表的节点相加
     * ，处理进位问题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
       if (null==l1) return l2;
       if (null==l2) return l1;
       //初始化头节点
       ListNode prev = new ListNode(0);
       ListNode head =prev;
       //表示进位
       int carry=0;
       while (l1!=null||l2!=null||carry!=0){
           ListNode node = new ListNode(0);//初始化结点
           //每个节点的数字相加，再加上上一位的进位
           int sum = ((null==l1)?0:l1.val)+((null==l2)?0:l2.val)+carry;
           //相加节点的值，如果相加=9，则 9%10=9 ，11%10=1
           node.val=sum%10;
           //进位 9/10 = 0 11/10=1;
           carry =sum/10;//进位
           //链表插入到末尾
           head.next=node;
           head=node;
           l1 = (null==l1)?l1:l1.next;
           l2 = (null==l2)?l2:l2.next;

       }
       //不能返回prev，因为prev是自己new出来的，多加的，他的子节点才是两个链表节点相加的结果
       return prev.next;
    }

    /**
     * 将每个链表都转成int值
     *
     * @param l1
     * @return
     */
    private int pareseToInt(ListNode l1) {
        int result = 0;
        List<Integer> valueInteger = new ArrayList<>();
        //342  --> 2 4 3
        ListNode vo = l1;
        do {
            valueInteger.add(vo.val);
            vo = vo.next;
        } while (vo != null);
        int len = valueInteger.size();
        for (int x = len - 1; x <= len && x >= 0; x--) {
            int value = valueInteger.get(x);
            result = (int) (result + value * Math.pow(10, x));
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        //System.out.println(pareseToInt(l1));

    }


}
