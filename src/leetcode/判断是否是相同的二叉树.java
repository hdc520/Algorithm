package leetcode;

import comAlgo.tree.TreeNode;

public class 判断是否是相同的二叉树 {
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }if(p!=null&&q!=null&&p.val==q.val){
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }
}
