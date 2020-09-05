package leetcode;

import comAlgo.list.ListNode;

import java.util.Stack;

public class A_25_翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1||head==null){
            return head;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode l=new ListNode(-1);
        ListNode cur=l;
        int count;
        while(head!=null){
            ListNode r=head;
            for(count=0;count<k;count++){
                if(head==null){
                    break;
                }
                stack.push(head);
                head=head.next;
            }
            if(count<k){
                cur.next=r;
                break;
            }
            while(!stack.isEmpty()){
                cur.next=stack.pop();
                cur=cur.next;
            }
            cur.next=head;
        }
        return l.next;
    }
}
