package leetcode;

import comAlgo.tree.TreeNode;

import java.util.*;

public class A_105_前中序构造二叉树 {
    Map<Integer,Integer> map=new HashMap<>();
    int []preorder;
    int []inorder;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        index=0;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int leftIndex=0,rightIndex=inorder.length;
        return BFSbuildTree(leftIndex,rightIndex);
    }

    public TreeNode BFSbuildTree(int leftIndex,int rightIndex){
        if(leftIndex==rightIndex){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=BFSbuildTree(leftIndex,map.get(root.val));
        root.right=BFSbuildTree(map.get(root.val)+1,rightIndex);
        return root;
    }
}
