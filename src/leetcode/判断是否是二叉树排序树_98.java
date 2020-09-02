package leetcode;

import comAlgo.tree.TreeNode;

public class 判断是否是二叉树排序树_98 {
    /*
    （1）利用左右子树的最大与最小值判断
    （2）利用二叉排序树中序遍历是有序的性质判断
     */
    public boolean isValid(TreeNode root){
        long max=Long.MAX_VALUE,min=Long.MIN_VALUE;
        return bfs(root,max,min);
    }
    public boolean bfs(TreeNode root,long max,long min){
        if(root==null){
            return true;
        }
        if(root.val<max&&root.val>min){
            return bfs(root.left,root.val,min)&&bfs(root.right,max,root.val);
        }
        return false;
    }

}
