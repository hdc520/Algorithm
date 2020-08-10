package leetcode;

public class 求平方根_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(15));
    }

    public static int mySqrt(int num){
        int left=1,right=num/2;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid==num){
                return mid;
            }else if(mid*mid>num){
                right=mid-1;
            }else{
                ans=left;
                left=mid+1;
            }
        }
        return ans;
    }
}
