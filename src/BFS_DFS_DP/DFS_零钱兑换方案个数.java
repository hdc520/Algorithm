package BFS_DFS_DP;

import java.util.*;

public class DFS_零钱兑换方案个数 {
     int sum;
     public int change(int amount, int[] coins) {
         sum=0;
         Arrays.sort(coins);
         backTrack(amount,coins,0);
         return sum;
     }
     public void backTrack(int amount, int[] coins,int cur){
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
