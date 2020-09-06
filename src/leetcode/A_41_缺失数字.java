package leetcode;

import java.util.Arrays;

public class A_41_缺失数字 {
    //方法一：指针指向
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i]=nums.length+1;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])>nums.length){
                continue;
            }
            int index=Math.abs(nums[i]);
            if(nums[index-1]<0){
                continue;
            }
            nums[index-1]=-1*nums[index-1];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
    //方法二：排序查找/注意去重
    public int firstMissingPositive_sort(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        Arrays.sort(nums);
        int temp=1;
        for(int i=0;i<nums.length;i++){
            if(i+1<nums.length&&nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i]>0){
                if(temp!=nums[i]){
                    return temp;
                }else{
                    temp++;
                }
            }
        }
        return temp;
    }
}
