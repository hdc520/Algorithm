package leetcode;

import java.util.Arrays;

public class A_16_最接近的三数之和 {
    /*
    注意目标值与和的比较
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeNum=Integer.MAX_VALUE;
        int ans=0;
        int left,right;
        for(int i=0;i<nums.length;i++){
            left=i+1;
            right=nums.length-1;
            while(left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if(temp==target)
                    return temp;
                else if(temp>target){
                    right--;
                }else{
                    left++;
                }
                if(Math.abs(target-temp)<closeNum){
                    ans=temp;
                    closeNum=Math.abs(target-temp);
                }

            }
        }
        return ans;
    }
}
