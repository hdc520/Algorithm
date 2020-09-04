package leetcode;

import comAlgo.list.ListNode;

public class A_19_删除倒数第N个节点 {
    //遍历求解
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0||head==null){
            return head;
        }
        ListNode p=head;
        ListNode r=head;
        while(n>0){
            p=p.next;
            n--;
        }
        if(p==null)
        while(p.next!=null){
            p=p.next;
            r=r.next;
        }
        r.next=r.next.next;
        return head;
    }

    //递归求解
    int cur=0;
     public ListNode removeNthFromEnd_tmp(ListNode head, int n) {
         if(head==null){
             return null;
         }
         head.next=removeNthFromEnd(head.next,n);
         cur++;
         if(cur==n){
             return head.next;
         }
         return head;
     }
}
