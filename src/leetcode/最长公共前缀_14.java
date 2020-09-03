package leetcode;

import java.util.Arrays;

public class 最长公共前缀_14 {
    /*
    先排序，然后取第一个字符串和最后一个字符串进行比较求得最长公共子序列；
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        StringBuilder s=new StringBuilder();
        for(int i=0;i<Math.min(strs[0].length(),strs[strs.length-1].length());i++){
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
                s.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return s.toString();
    }
}
