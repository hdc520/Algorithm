package comAlgo.list;

public class 链表逆置 {
    public static void main(String[] args) {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(3);
        p1.next=p2;p2.next=p3;p3.next=null;
        ListNode head=reverseList(p1).next;
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode l=new ListNode(-1);
        l.next=null;
        ListNode p;
        while(head!=null){
            p=head.next;
            head.next=l.next;
            l.next=head;
            head=p;
        }
        return l;
    }
}
