package leetcode;

public class A_81搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[right]>nums[mid]){
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else if(nums[right]<nums[mid]){
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                while(left<=right&&nums[left]==nums[mid]) left++;
                while(left<=right&&nums[right]==nums[mid]) right--;
            }
        }
        return false;
    }
}
