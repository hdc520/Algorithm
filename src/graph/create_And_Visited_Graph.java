package graph;

import java.util.*;

public class create_And_Visited_Graph {
    //邻接表如下
    /*
    1->2-5
    2->1-5-4
    3->2-4
    4->2-5-3
    5->4-1-2
     */
    public static void main(String[] args) {
        //创建图节点
        graphNode n1=new graphNode(1);
        graphNode n2=new graphNode(2);
        graphNode n3=new graphNode(3);
        graphNode n4=new graphNode(4);
        graphNode n5=new graphNode(5);

        //创建邻接表
        n1.neighbors.add(n2);
        n1.neighbors.add(n5);

        n2.neighbors.add(n1);
        n2.neighbors.add(n5);
        n2.neighbors.add(n4);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n2);
        n4.neighbors.add(n5);
        n4.neighbors.add(n3);

        n5.neighbors.add(n4);
        n5.neighbors.add(n1);
        n5.neighbors.add(n2);
        //深度优先遍历
        DFS(n1);
//        System.out.println();
        //广度优先遍历
//        BFS(n1);

    }
    //深度优先遍历
    public static void DFS(graphNode root){
        if (root == null) {
            return;
        }
        root.visited=true;
        System.out.print(root.val+" ");
        for (graphNode node : root.neighbors) {
            if (!node.visited) {
                DFS(node);
            }
        }
    }

    //广度优先遍历
    public static void BFS(graphNode root) {
        Queue<graphNode> queue = new LinkedList<>();
        queue.offer(root);
        root.visited=true;
        while (!queue.isEmpty()) {
            graphNode r = queue.poll();
            System.out.print(r.val+" ");
            for (graphNode node : r.neighbors) {
                if (!node.visited) {
                    queue.offer(node);
                    node.visited=true;
                }
            }
        }
    }
}