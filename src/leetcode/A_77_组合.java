package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_77_组合 {
    static List<List<Integer>> ans=new ArrayList<>();
    public static void main(String[] args) {
        combine(4,2);
        for(List l:ans){
            for(Object i:l.toArray()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> track=new ArrayList<>();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }

        backTrack(nums,track,k,0);
        return ans;
    }

    public static void backTrack(int nums[],List<Integer> track,int k,int cur){
        if(track.size()==k){
            ans.add(new ArrayList<>(track));
            return;
        }
        if(track.size()>k){
            return;
        }
        for(int i=cur;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track,k,i+1);
            track.remove(track.size()-1);
        }
    }
}
