package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 无重复的最长字串_3 {
    /*
    利用set作为滑动窗口求解
     */
    public int lengthOfLongestSubstring(String s) {
        int max=0,left=0,right=0;
        Set<Character> set=new HashSet<>();
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max=max>(right-left)?max:(right-left);
            }
            else{
                System.out.println(right);
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
