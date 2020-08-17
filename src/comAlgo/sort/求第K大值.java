package comAlgo.sort;

public class 求第K大值 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{0,1,2,3,6,7,9,4,5,8},4));
    }
    public static int findKthLargest(int nums[],int k){
        int left=0,right=nums.length-1;
        while(left<=right){
            int location=getPartition(nums,left,right);
            if(location>k-1){
                right=location-1;
            }else if(location<k-1){
                left=location+1;
            }else {
                return nums[location];
            }
        }
        return nums[left];
    }

    private static int getPartition(int[] nums, int left, int right) {
        int temp=nums[left];
        while(left<right){
            while(left<right&&temp<nums[right]){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&temp>nums[left]){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
}
