package com.lrw.algorithm.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 将每个链表的值转成int ,然后两个int 相加 最后再转成链表 =>
     * 结果：未通过，缺陷，因为不int的取值范围很小，链表很容易超过int范围
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
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     * 这个思路是我延续上一道题的，这道题与上道题的不同点在于，数的顺序问题，可能要进行反转
     * addTwoNumbers3 思路：对长度较小的链表进行前面补0，然后每个节点相加，后面发现，需要反转，
     * 带来的问题就是增加了时间消耗，放弃了这种解法。
     *
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (null==l1) return l2;
        if (null==l2) return l1;
        //在长度较小的链表前面补0
        int l1Len = 1;
        int l2Len = 1;
        ListNode l1copy = new ListNode(l1.val);
        l1copy.next = l1.next;
        ListNode l2copy =  new ListNode(l2.val);
        l2copy.next= l2.next;
        //获取两个链表的长度
        while (l1.next!=null){
            l1Len++;
            l1=l1.next;
        }
        while (l2.next!=null){
            l2Len++;
            l2=l2.next;
        }
        ListNode head = l1copy;
        ListNode head2 = l2copy;
        //不足的前面补0
        if (l1Len<l2Len){
            int len = l2Len-l1Len;
            for (int x=0;x<len;x++){
                ListNode vo = new ListNode(0);
                vo.next=head;
                head =vo;
            }
        }else if (l2Len<l1Len){
            int len = l1Len-l2Len;
            for (int x=0;x<len;x++){
                ListNode vo = new ListNode(0);
                vo.next=head2;
                head2 =vo;
            }
        }
        l1 = head;
        l2 = head2;
        //初始化头节点
        ListNode prev = new ListNode(0);
        ListNode resulutHead =prev;
        //表示进位
        int carry=0;
        List<ListNode> list1 = new ArrayList<>();
        while (l1!=null||l2!=null||carry!=0){

            ListNode node = new ListNode(0);//初始化结点
            //每个节点的数字相加，再加上上一位的进位

            int sum = ((null==l1)?0:l1.val)+((null==l2)?0:l2.val)+carry;
            //相加节点的值，如果相加=9，则 9%10=9 ，11%10=1
            node.val=sum%10;
            //进位 9/10 = 0 11/10=1;
            carry =sum/10;//进位
            //链表插入到末尾
            resulutHead.next=node;
            resulutHead=node;
            l1 = (null==l1)?l1:l1.next;
            l2 = (null==l2)?l2:l2.next;

        }
        //不能返回prev，因为prev是自己new出来的，多加的，他的子节点才是两个链表节点相加的结果
        return prev.next;
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 执行用时 :6 ms, 在所有 Java 提交中击败了32.19%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了95.83%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();//结果集
        //入栈
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        //出栈做加法
        int carry = 0; //设置进位
        while (!(l1Stack.isEmpty()) || !(l2Stack.isEmpty()) || carry != 0) {
            int sum = (l1Stack.isEmpty() ? 0 : l1Stack.pop()) + (l2Stack.isEmpty() ? 0 : l2Stack.pop()) + carry;
            resultStack.push((sum % 10));
            carry = sum / 10;
        }
        Object[] resultArray = resultStack.toArray();
        ListNode head = new ListNode(0);
        ListNode headCopy = new ListNode(0);
        for (int x = resultArray.length - 1; x >= 0; x--) {
            ListNode vo = new ListNode((Integer) resultArray[x]);
            if (x == resultArray.length - 1) {
                headCopy.next = vo;
            }
            head.next = vo;
            head = vo;
        }
        head = headCopy;
        return head.next;
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
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);
        l5.next = l6;
        l6.next = l7;
//        ListNode vo = addTwoNumbers3(l1,l5);
//        while (vo.next!=null){
//            System.out.println(vo.val);
//            vo=vo.next;
//        }

      ListNode node  = addTwoNumbers4(l1,l5);
      while (node!=null){
          System.out.println(node.val);
          node = node.next;
      }

        //System.out.println(pareseToInt(l1));

    }


}
