package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_93_复原ip地址 {
    public static void main(String[] args) {
        for(String s:restoreIpAddresses("25525511135")){
            System.out.println(s);
        }
    }
    public static List<String> restoreIpAddresses(String s){
        List<String> ans=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                for(int p=1;p<4;p++){
                    for(int q=1;q<4;q++){
                        if(i+j+p+q==s.length()){
                            int a=Integer.parseInt(s.substring(0,i));
                            int b=Integer.parseInt(s.substring(i,i+j));
                            int c=Integer.parseInt(s.substring(i+j,i+j+p));
                            int d=Integer.parseInt(s.substring(i+j+p));
                            if(a<=255&&b<=255&&c<=255&&d<=255){
                                str.append(a+".").append(b+".").append(c+".").append(d);
                                if(str.length()==s.length()+3){
                                    ans.add(str.toString());
                                }
                                str.delete(0,str.length());
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
