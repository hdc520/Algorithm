package comAlgo.interview;

import java.util.HashMap;
import java.util.Map;

public class ch2num {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
//        String s="一亿零八万零三百二十三";
        String s="十三";
        int r=1,num=0;
        map.put("零",0);map.put("一",1);map.put("二",2);map.put("两",2);
        map.put("三",3);map.put("四",4);map.put("五",5);map.put("六",6);
        map.put("七",7);map.put("八",8);map.put("九",9);map.put("十",10);
        map.put("百",100);map.put("千",1000);map.put("万",10000);map.put("亿",100000000);
        for(int i=s.length()-1;i>=0;i--){
            String c=s.charAt(i)+"";
            if(map.get(c)<10){
                num+=r*map.get(c);
            }else if(map.get(c)>9){
                if(i==0){
                    num+=10;
                }else{
                    r=map.get(c);
                }
            }
        }
        System.out.println(num);
    }
}
