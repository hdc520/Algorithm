package leetcode;

import comAlgo.list.ListNode;

public class A_2_链表表示的两数之和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode r=head;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            ListNode p=new ListNode(carry%10);
            carry=carry/10;
            r.next=p;
            r=p;
        }
        return head.next;
    }
}
