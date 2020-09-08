package leetcode;

import java.util.*;

public class A_56_合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length==0){
                return intervals;
            }
            List<int[]> list=new LinkedList<>();
            int min;
            for(int i=0;i<intervals.length;i++){
                min=i;
                for(int j=i+1;j<intervals.length;j++){
                    if(intervals[min][0]>intervals[j][0]){
                        min=j;
                    }
                }
                if(min!=i){
                    int []temp=intervals[min];
                    intervals[min]=intervals[i];
                    intervals[i]=temp;
                }
                for(int p:intervals[i]){
                    System.out.print(p+" ");
                }
                System.out.println();
            }
            list.add(intervals[0]);
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]>list.get(list.size()-1)[1]){
                    list.add(intervals[i]);
                }else{
                    list.get(list.size()-1)[0]=Math.min(list.get(list.size()-1)[0],intervals[i][0]);
                    list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],intervals[i][1]);
                }
            }
            int ans[][]=new int[list.size()][2];
            for(int i=0;i<list.size();i++){
                ans[i]=list.get(i);
            }
            return ans;
        }
    }
}
