package BFS_DFS_DP;

import java.util.*;

public class DP_零钱兑换最少硬币数 {
    public int coinChange1(int[] coins, int amount) {
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

    //方法二
    static int min;
    public static int coinChange2(int[] coins, int amount) {
        min=amount+1;
        Arrays.sort(coins);
        List<Integer> track =new ArrayList<>();
        backTrack(coins,track,amount,coins.length-1);
        if(min==amount+1){
            return -1;
        }
        return min;
    }
    public static void backTrack(int[] coins, List<Integer> track,int amount,int cur){
        if(amount<0){
            return;
        }
        if(amount==0){
            if(min>track.size()){
                min=track.size();
            }
            return;
        }
        for(int i=cur;i>=0;i--){
            if(amount-coins[i]<0){
                continue;
            }
            track.add(coins[i]);
            backTrack(coins,track,amount-coins[i],i);
            track.remove(track.size()-1);
        }
    }
}
