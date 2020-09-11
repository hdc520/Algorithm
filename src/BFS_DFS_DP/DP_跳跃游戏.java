package BFS_DFS_DP;

import java.util.Arrays;

public class DP_跳跃游戏 {
    public int jump(int[] nums) {
        int DP[]=new int[nums.length];
        Arrays.fill(DP,nums.length);
        DP[0]=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]+j>=i){
                    DP[i]=Math.min(DP[i],DP[j]+1);
                }
            }
        }
        return DP[nums.length-1];
    }
}
