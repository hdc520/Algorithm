package leetcode;

import comAlgo.list.ListNode;
import comAlgo.tree.TreeNode;


public class A_109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head){
        if(head==null){
            return null;
        }
        ListNode fast=head,slow=head,pre=null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;
    }
}
