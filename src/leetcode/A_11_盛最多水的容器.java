package leetcode;

public class A_11_盛最多水的容器 {
    /*
    定义左右双指针，面积取决于指针的距离与值小的乘积，值大的指针向内移动则面积减小
    值小的向内移动，面积可能增大。
     */
    public int maxArea(int[] height) {
        int max=0,left=0,right=height.length-1;
        while(left<right){
            max=Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
