package BFS_DFS_DP;

import java.util.Arrays;

public class DP_零钱兑换方案个数 {
    static int sum=0;
    public int change2(int amount, int[] coins) {
        if(amount<=0){
            return 1;
        }
        Arrays.sort(coins);
        int n=coins.length;
        int DP[][]=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            DP[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j-coins[i-1]<0){
                    DP[i][j]=DP[i-1][j];
                }
                else{
                    DP[i][j] = DP[i - 1][j] + DP[i][j - coins[i-1]];
                }
            }
        }
        return DP[n][amount];
    }

    //方法二
    public static int change1(int amount, int[] coins) {
        Arrays.sort(coins);
        backTrack(amount,coins,0);
        return sum;
    }
    public static void backTrack(int amount, int[] coins,int cur){
        if(amount==0){
            sum++;
            return;
        }
        if(amount<0){
            return;
        }
        for(int i=cur;i<coins.length;i++){
            if(amount<0){
                break;
            }
            backTrack(amount-coins[i],coins,i);
        }
    }
}
