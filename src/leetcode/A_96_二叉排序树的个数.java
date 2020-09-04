package leetcode;

public class A_96_二叉排序树的个数 {
    /*
    假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数
    则G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
    当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则f(i)=G(i−1)∗G(n−i)
     */
    public static void main(String[] args) {
        int n=5;
        int DP[]=new int[n+1];
        DP[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                DP[i]+=DP[j-1]*DP[i-j];
            }
        }
        System.out.println(DP[n]);
    }
}
