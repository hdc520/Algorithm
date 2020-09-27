package leetcode;

import comAlgo.tree.TreeNode;

public class A_101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return judge(root.left,root.right);
    }
    public boolean judge(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }if(p==null&&q!=null){
            return false;
        }if(p!=null&&q==null){
            return false;
        }if(p.val==q.val){
            return judge(p.left,q.right)&&judge(p.right,q.left);
        }
        return false;
    }
}
