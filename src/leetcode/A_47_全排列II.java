package leetcode;
import java.util.*;
public class A_47_全排列II {
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        DFS(nums,0);
        return new ArrayList<>(set);
    }
    public void DFS(int[] nums,int cur){
        if(cur==nums.length){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                l.add(nums[i]);
            }
            set.add(l);
            return;
        }
        for(int i=cur;i<nums.length;i++){
            if(i>cur&&nums[i]==nums[i-1]){
                continue;
            }
            swap(nums,cur,i);
            DFS(nums,cur+1);
            swap(nums,cur,i);
        }
    }
    public void swap(int nums[],int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
