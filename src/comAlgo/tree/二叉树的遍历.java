package comAlgo.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 二叉树的遍历 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode left=new TreeNode(1);
        TreeNode right=new TreeNode(2);
        TreeNode rightSub=new TreeNode(3);
        root.left=left;root.right=right;right.left=rightSub;
        //层次遍历
        BFS(root);
        System.out.println();
        //先序遍历
        preDFS(root);
        //中序遍历
        System.out.println();
        midDFS(root);
        //后序遍历
        System.out.println();
        postDFS(root);
        //求树高
        System.out.println();
        System.out.println("树高："+treeHigh(root));
        //求叶子节点个数
        System.out.println("叶子节点个数："+leafNum(root));
        //判断是否是平衡二叉树
        System.out.println("判断是否是平衡二叉树："+judgeBalanced(root));
    }

    //层次遍历
    public static void BFS(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                System.out.print(temp.val+" ");
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
    }

    //先序遍历
    public static void preDFS(TreeNode root){
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                System.out.print(p.val+" ");
                stack.push(p);
                p=p.left;
            }else{
                p=stack.pop();
                p=p.right;
            }
        }
    }

    //中序遍历
    public static void midDFS(TreeNode root){
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                p=stack.pop();
                System.out.print(p.val+" ");
                p=p.right;
            }
        }
    }
    //后序遍历
    public static void postDFS(TreeNode root){
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=root,r=null;
        while(p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.peek();
                if(p.right!=null&&p.right!=r){
                    p=p.right;
                    stack.push(p);
                    p=p.left;
                }else{
                    p=stack.pop();
                    System.out.print(p.val+" ");
                    r=p;
                    p=null;
                }
            }
        }
    }

    //求树高
    public static int treeHigh(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=treeHigh(root.left)+1;
        int right=treeHigh(root.right)+1;
        return left>right?left:right;
    }

    //求叶子节点
    public static int leafNum(TreeNode root){
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }
        return leafNum(root.left)+leafNum(root.right);
    }
    //判断是否是平衡二叉树
    public static boolean judgeBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int left=treeHigh(root.left);
        int right=treeHigh(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return judgeBalanced(root.right)&&judgeBalanced(root.left);
    }
}
