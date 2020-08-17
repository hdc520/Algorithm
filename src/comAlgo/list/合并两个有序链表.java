package comAlgo.list;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(3);
        ListNode p3=new ListNode(7);
        p1.next=p2;p2.next=p3;p3.next=null;
        ListNode s1=new ListNode(2);
        ListNode s2=new ListNode(4);
        ListNode s3=new ListNode(6);
        s1.next=s2;s2.next=s3;s3.next=null;
        ListNode head=mergeList(p1,s1);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        if(l1.val>l2.val){
            l2.next=mergeList(l1,l2.next);
            return l2;
        }else {
            l1.next=mergeList(l2,l1.next);
            return l1;
        }
    }
}
