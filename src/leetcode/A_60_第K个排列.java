package leetcode;

import java.util.*;

public class A_60_第K个排列 {
    List<String> list=new ArrayList<>();
    int flag=0;
    public String getPermutation(int n, int k) {
        List<Character> track=new ArrayList<>();
        int nums[]=new int[n];
        int visited[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        backTrack(nums,track,visited,k);
        return list.get(k-1);
    }

    public void backTrack(int nums[],List<Character> track,int visited[],int k){
        if(flag==1){
            return;
        }
        if(nums.length==track.size()){
            StringBuilder str=new StringBuilder();
            for(char c:track){
                str.append(c);
            }
            list.add(str.toString());
            if(list.size()==k){
                flag=1;
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag==1){
                return;
            }
            if(visited[i]==0)
            {
                visited[i]=1;
                track.add((char)('0' + nums[i]));
                backTrack(nums,track,visited,k);
                visited[i]=0;
                track.remove(track.size()-1);
            }
        }
    }
}
