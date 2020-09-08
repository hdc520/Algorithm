package leetcode;

public class A_55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,i+nums[i]);
            if(nums[i]==0){
                if(max<=i&&i!=nums.length-1){
                    return false;
                }
            }
        }
        return true;
    }
}
