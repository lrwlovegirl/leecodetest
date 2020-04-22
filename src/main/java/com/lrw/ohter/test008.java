package com.lrw.ohter;

/**
 * @Author: xiaoyao
 * @Date: 2020/4/10 18:14
 */
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}
public class test008 {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
       ListNode1 tempHead=l1;
        while (l1!=null){
            System.out.println("l1-"+l1.val);
            l1=l1.next;
        }
        ListNode1 rl1=rev(tempHead);
        //ListNode1 rl2=rev(l2);
        while (tempHead!=null){
            System.out.println("tempHead"+tempHead.val);
            tempHead=tempHead.next;
        }
        /**设置一个进位*/
        ListNode1 prev=new ListNode1(0);
        ListNode1 head=prev;
        int current=0;
        while (l1!=null||l2!=null||current!=0){
            ListNode1 temp;
            int sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+current;
            temp=new ListNode1(sum%10);
            current=sum/10;
            head.next=temp;
            head=temp;
            l1=(l1==null?null:l1.next);
            l2=(l2==null?null:l2.next);
        }
        return prev.next;
    }

    public static ListNode1 rev(ListNode1 head){
        if (head == null){
            return head;
        }
        ListNode1 dummy = new ListNode1(-1);
        dummy.next = head;
        ListNode1 prev = dummy.next;
        ListNode1 pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }




    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1(2);
        ListNode1 l2 = new ListNode1(4);
        ListNode1 l3 = new ListNode1(3);
        l1.next=l2;
        l2.next=l3;
        rev(l1);
        while (l1!=null){
            System.out.println(l1.val);
            l1=l1.next;
        }

    }



}
