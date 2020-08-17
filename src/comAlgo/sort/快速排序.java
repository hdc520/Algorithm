package comAlgo.sort;

//利用三位取中法可以优化快速排序
public class 快速排序 {
    public static void main(String[] args) {
        int nums[]=new int[]{0,1,9,2,5,3,7,4,8,6};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int nums[],int left,int right){
        if(left<right){
            int partition=getPartition(nums,left,right);
            quickSort(nums,left,partition-1);
            quickSort(nums,partition+1,right);
        }
    }
    public static int getPartition(int nums[],int left,int right){
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
