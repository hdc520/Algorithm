package leetcode;

import java.util.*;

public class A_40_组合II {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer>track=new ArrayList<>();
        dfs(candidates,track,0,target);
        return ans;
    }
    public void dfs(int[] candidates,List<Integer>track,int cur,int target){
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=cur;i<candidates.length;i++){
            if(i>cur&&candidates[i]==candidates[i-1]){
                continue;
            }
            track.add(candidates[i]);
            dfs(candidates,track,i+1,target-candidates[i]);
            track.remove(track.size()-1);
        }
    }
}
