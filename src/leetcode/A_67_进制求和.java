package leetcode;

public class A_67_进制求和 {
    public static void main(String[] args) {
        String a="111111111";
        String b="1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        int carry=0;
        int len1=a.length()-1,len2=b.length()-1;
        StringBuilder stringBuilder=new StringBuilder();
        while(len1>=0||len2>=0){
            int aa=len1<0?0:a.charAt(len1)-'0';
            int bb=len2<0?0:b.charAt(len2)-'0';
            int temp=aa+bb+carry;
            carry=temp/2;
            stringBuilder.append(temp%2);
            len1--;
            len2--;
        }
        if(carry==1){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
