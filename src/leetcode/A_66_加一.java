package leetcode;

public class A_66_加一 {
    public static void main(String[] args) {
        int nums[]=new int[]{9,9,9,9,9,9};
        for(int i:plusOne(nums)){
            System.out.print(i+" ");
        }
    }

    public static int[] plusOne(int nums[]){
        for(int i=nums.length-1;i>=0;i--){
            nums[i]++;
            if(nums[i]<10){
                return nums;
            }
            nums[i]=nums[i]%10;
        }
        int ans[]=new int[nums.length+1];
        ans[0]=1;
        return ans;
    }
}
