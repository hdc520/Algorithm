package leetcode;

import java.util.*;

public class A_17_电话号码的字母组合 {
    static List<String> ans=new ArrayList<>();
    static Map<String,String>map=new HashMap<>();
    public static void main(String[] args) {
        StringBuilder track=new StringBuilder();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        backtrack("23",track,0);
        for(String s:ans){
            System.out.println(s);
        }

    }
    public static void backtrack(String s,StringBuilder track,int index){
        if(index==s.length()){
            ans.add(new String(track.toString()));
            return;
        }
        String tmpStr=map.get(s.substring(index,index+1));
        for(int i=0;i<tmpStr.length();i++){
            track.append(tmpStr.substring(i,i+1));
            backtrack(s,track,index+1);
            track.replace(track.length()-1,track.length(),"");
        }
    }
}
