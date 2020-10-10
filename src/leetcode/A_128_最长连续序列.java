package leetcode;

import java.util.*;

public class A_128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int count=1,max=0;
        for(int i:set){
            int cur=i;
            if(!set.contains(cur-1)){
                count=1;
                while(set.contains(cur+1)){
                    count++;
                    cur++;
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
