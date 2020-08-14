package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II_90 {
    public static List<List<Integer>> ans;
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
        for(List l:ans){
            for(Object i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> track=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            backTrack(nums,track,i,0);
        }
    }

    public static void backTrack(int nums[],List<Integer> track,int k,int cur){
        if(track.size()==k){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=cur;i<nums.length;i++){
            if(i>cur&&nums[i]==nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track,k,i+1);
            track.remove(track.size()-1);
        }
    }
}
