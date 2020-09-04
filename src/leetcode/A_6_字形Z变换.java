package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_6_字形Z变换 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuilder> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int curRow=0,flag=1;
        for(int i=0;i<s.length();i++){
            list.get(curRow).append(s.charAt(i));
            if(curRow==numRows-1){
                flag=-1;
            }
            if(curRow==0){
                flag=1;
            }
            curRow+=flag;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<numRows;i++){
            System.out.println(list.get(i).toString());
            ans.append(list.get(i).toString());
        }
        return ans.toString();
    }
}
