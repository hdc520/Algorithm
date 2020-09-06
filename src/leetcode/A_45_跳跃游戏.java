package leetcode;

import java.util.*;

public class A_45_跳跃游戏 {
    //DP求解
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
    //BFS求解
    public int BFS(int[] nums) {
         if(nums.length==0||nums.length==1){
             return 0;
         }
         Queue<Integer>queue=new LinkedList<>();
         int step=0;
         queue.offer(0);
         int n=nums.length-1;
         while(!queue.isEmpty()){
             int size=queue.size();
             for(int i=0;i<size;i++){
                 int index=queue.poll();
                 for(int p=nums[index];p>=1;p--){
                     if(index+p>=n){
                         step++;
                         return step;
                     }
                     queue.offer(index+p);
                 }
             }
             step++;
         }
         return step;
     }
}
