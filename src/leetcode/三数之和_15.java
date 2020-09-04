package leetcode;

import java.util.*;

public class 三数之和_15 {
    /*
    注意去重方法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        int left,right;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            left=i+1;
            right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
                    set.add(temp);
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
