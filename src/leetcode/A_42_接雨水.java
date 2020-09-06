package leetcode;

public class A_42_接雨水 {
    /*
    1、找出最高点
    2、分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
     */
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int max=0,index=0,ans=0;
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max=height[i];
                index=i;
            }
        }
        int init=height[0];
        for(int i=1;i<index;i++){
            if(init>height[i]){
                ans+=(init-height[i]);
            }else{
                init=height[i];
            }
        }
        init=height[height.length-1];
        for(int i=height.length-2;i>index;i--){
            if(init>height[i]){
                ans+=(init-height[i]);
            }else{
                init=height[i];
            }
        }
        return ans;
    }
}
