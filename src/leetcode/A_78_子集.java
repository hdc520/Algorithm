package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_78_子集 {
    static List<List<Integer>> ans=new ArrayList<>();
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
        for(List l:ans){
            for(Object i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<Integer> track=new ArrayList<>();
//        ans.add(track);
        for(int i=0;i<nums.length+1;i++){
            backTrack(nums,track,i,0);
        }
        return ans;
    }

    public static void backTrack(int nums[],List<Integer>track ,int k,int cur){
        if(track.size()==k){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=cur;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track, k, i+1);
            track.remove(track.size()-1);
        }
    }
}
