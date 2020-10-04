package comAlgo.tree;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p.val>q.val){
            TreeNode t=p;
            p=q;
            q=t;
        }
        return judge(root,p,q);
    }
    public TreeNode judge(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root.val==p.val||root.val==q.val){
            return root;
        }
        if(root.val>p.val&&root.val<q.val){
            return root;
        }
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
