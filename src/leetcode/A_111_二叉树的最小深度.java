package leetcode;

import comAlgo.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class A_111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        int count=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            count++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode p=queue.poll();
                if(p.left==null&&p.right==null){
                    return count;
                }
                if(p.left!=null){
                    queue.offer(p.left);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                }
            }
        }
        return count;
    }
}
