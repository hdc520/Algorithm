package BFS_DFS_DP;

import java.util.Collections;
import java.util.TreeMap;

public class DP_零钱兑换最少硬币数 {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0){
            return 0;
        }
        int memo[]=new int[amount+1];
        memo[0]=0;
        for(int i=1;i<memo.length;i++){
            memo[i]=amount+1;
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                memo[i]=Math.min(memo[i],memo[i-coin]+1);
            }
        }
        if(memo[amount]==amount+1){
            return -1;
        }
        return memo[amount];
    }
}
