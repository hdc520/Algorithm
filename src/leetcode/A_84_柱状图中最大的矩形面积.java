package leetcode;

public class A_84_柱状图中最大的矩形面积 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<heights.length;i++){
            min=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                min=Math.min(min,heights[j]);
                ans=Math.max(ans,(j-i+1)*min);
            }
        }
        return ans;
    }
}
