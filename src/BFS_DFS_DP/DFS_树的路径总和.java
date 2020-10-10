package BFS_DFS_DP;

import comAlgo.tree.TreeNode;

import java.util.*;

public class DFS_树的路径总和 {
    //是否存在路径总和
    public boolean hasPathSum(TreeNode root, int sum) {
         if (root == null) {
             return false;
         }
         if (root.left == null && root.right == null) {
             return sum - root.val == 0;
         }
         return hasPathSum(root.left, sum - root.val)
                 || hasPathSum(root.right, sum - root.val);
     }
     //输出存在的路径总和
     List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return ans;
        }
        List<Integer> path=new ArrayList<>();
        dfs(root,sum,path);
        return ans;
    }
    public void dfs(TreeNode root, int sum,List<Integer> path){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&sum-root.val==0){
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        dfs(root.left,sum-root.val,path);
        dfs(root.right,sum-root.val,path);
        path.remove(path.size()-1);
    }
}
