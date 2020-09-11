package BFS_DFS_DP;

import java.util.*;

public class DFS_零钱兑换最少硬币数 {
    int min;
    public int coinChange(int[] coins, int amount) {
        min=amount+1;
        Arrays.sort(coins);
        List<Integer> track =new ArrayList<>();
        backTrack(coins,track,amount,coins.length-1);
        if(min==amount+1){
            return -1;
        }
        return min;
    }
    public void backTrack(int[] coins, List<Integer> track,int amount,int cur){
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
