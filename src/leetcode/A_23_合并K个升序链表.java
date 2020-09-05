package leetcode;

import comAlgo.list.ListNode;

import java.util.*;

public class A_23_合并K个升序链表 {
    /*
    使用优先队列构造最小堆，堆顶元素最小
    记住比较器的定义
    private Comparator<Element> MyCmp = new Comparator<Element>() {
        @Override //升序
        public int compare(Element o1, Element o2) {
            return o1.val - o2.val;
        }
    }
    其中o1-o2为小顶堆，o2-o1为大顶堆。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        Queue<ListNode> minHeap=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });
        for(ListNode i:lists){
            if(i!=null){
                minHeap.offer(i);
            }
        }
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while(!minHeap.isEmpty()){
            ListNode p=minHeap.poll();
            cur.next=p;
            cur=cur.next;
            if(p.next!=null){
                minHeap.offer(p.next);
            }
        }
        return head.next;
    }
}
