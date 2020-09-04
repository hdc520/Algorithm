package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_46_无重复的全排列 {
    public static void main(String[] args) {
        List<List<Integer>> ans=premute(new int[]{2,3,4});
        for(List l:ans){
            for(Object i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> premute(int nums[]){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> track=new ArrayList<>();
        backTrack(ans,track,nums);
        return ans;
    }
    public static void backTrack(List<List<Integer>> ans,List<Integer> track,int nums[]){
        if(track.size()==nums.length){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(ans,track,nums);
            track.remove(track.size()-1);
        }
    }
}
