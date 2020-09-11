package BFS_DFS_DP;

import java.util.Arrays;

public class DP_零钱兑换方案个数 {
    public int change(int amount, int[] coins) {
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
}
