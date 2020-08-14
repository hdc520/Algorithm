package comAlgo;

public class 堆排序 {
    public static void main(String[] args) {
        int nums[]=new int[]{0,1,9,2,5,3,7,4,8,6};
        headSort(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void headSort(int nums[]){
        for(int i=nums.length/2-1;i>=0;i--){
            adjust(nums,i,nums.length);
        }
        for(int i=nums.length-1;i>=1;i--){
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            adjust(nums,0,i);
        }
    }
    public static void adjust(int nums[],int index,int len){
        int maxIndex=index;
        int left=index*2+1;
        int right=left+1;
        if(left<len&&nums[maxIndex]<nums[left]){
            maxIndex=left;
        }
        if(right<len&&nums[maxIndex]<nums[right]){
            maxIndex=right;
        }
        if(maxIndex!=index){
            int temp=nums[index];
            nums[index]=nums[maxIndex];
            nums[maxIndex]=temp;
            adjust(nums,maxIndex,len);
        }
    }

}
