package comAlgo;

public class 快速排序 {
    public static void main(String[] args) {
        int nums[]=new int[]{0,1,9,2,5,3,7,4,8,6};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int nums[],int low,int high){
        if(low<high){
            int partition=getPartition(nums,low,high);
            quickSort(nums,low,partition-1);
            quickSort(nums,partition+1,high);
        }
    }
    public static int getPartition(int nums[],int low,int high){
        int temp=nums[low];
        while(low<high){
            while(low<high&&temp<nums[high]){
                high--;
            }
            nums[low]=nums[high];
            while(low<high&&temp>nums[low]){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=temp;
        return low;
    }
}
