package leetcode;

public class A_7_数字反转 {
    /*
    利用Java中的异常来解决类型溢出问题
     */
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        long temp=(long)Math.abs(x);
        StringBuilder s=new StringBuilder();
        while(temp!=0){
            s.append(temp%10);
            temp=temp/10;
        }
        try{
            return Integer.parseInt(s.toString())*(x>0?1:-1);
        }catch(Exception e){
            return 0;
        }

    }
}
