package comAlgo.interview;

import java.util.HashMap;
import java.util.Map;

public class num2ch {
    public static void main(String[] args) {
//        String s="32050011";
//        String s="200890";
        String s="60000000";
        Map<Character,Character> numMap=new HashMap<>();
        numMap.put('0','零');numMap.put('1','一');numMap.put('2','二');
        numMap.put('3','三');numMap.put('4','四');numMap.put('5','五');
        numMap.put('6','六');numMap.put('7','七');numMap.put('8','八');
        numMap.put('9','九');
        if(s.length()==1){
            System.out.println(numMap.get(s.charAt(0)));
            System.exit(0);
        }
        Map<Integer,String> carryMap=new HashMap<>();
        carryMap.put(1,"");carryMap.put(2,"十");carryMap.put(3,"百");
        carryMap.put(4,"千");carryMap.put(5,"万");carryMap.put(6,"十");
        carryMap.put(7,"百");carryMap.put(8,"千");carryMap.put(9,"亿");
        carryMap.put(10,"十");carryMap.put(11,"百");carryMap.put(12,"千");
        StringBuilder ans=new StringBuilder();
        int flag=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='0'){
                if(flag==0){
                    ans.append(numMap.get('0'));
                }
                ans.append(numMap.get(c));
                ans.append(carryMap.get(s.length()-i));
                flag=1;
            }else{
                if(carryMap.get(s.length()-i).equals("万")
                        ||carryMap.get(s.length()-i).equals("亿")){
                    ans.append(carryMap.get(s.length()-i));
                    continue;
                }
                flag=0;
            }
        }
        System.out.println(ans.toString());
    }
}
