package leetcode;

public class A_27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int left=0,right=nums.length-1;
        while(left<=right){
            if(nums[left]==val){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
                count++;
            }else{
                left++;
            }
        }
        return nums.length-count;
    }
}
