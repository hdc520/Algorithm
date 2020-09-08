package leetcode;

public class A_50_快速幂 {
    public double myPow(double x, int n) {
        if(n==0||x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(x==-1){
            return (n&1)==1?-1:1;
        }
        double ans=1;
        int temp_n=Math.abs(n);
        while(temp_n>0){
            if((temp_n&1)==1){
                ans=ans*x;
            }
            x=x*x;
            temp_n=temp_n>>1;
        }
        if(ans==1){
            return 0;
        }
        return n>0?ans:1/ans;
    }
}
