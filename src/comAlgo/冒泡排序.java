package comAlgo;

public class 冒泡排序 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,3,2,5,4,7,9,0,6,8};
        Bsort(nums);
        for (int i:nums) {
            System.out.print(i+" ");
        }
    }
    public static void Bsort(int nums[]){
        int flag;
        for(int i=0;i<nums.length;i++){
            flag=0;
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0){
                return;
            }
        }
        return;
    }
}
