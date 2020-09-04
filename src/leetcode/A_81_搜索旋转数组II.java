package leetcode;

public class A_81_搜索旋转数组II {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2,2,2,2,2,5,6,2,2,2},5));
    }
    public static boolean search(int nums[],int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<nums[right]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else if(nums[mid]>nums[right]){
                if(nums[mid]>target&&nums[left]<=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                while(left<=right&&nums[mid]==nums[left]){
                    left++;
                }
                while(left<=right&&nums[mid]==nums[right]){
                    right--;
                }
            }
        }
        return false;
    }
}
