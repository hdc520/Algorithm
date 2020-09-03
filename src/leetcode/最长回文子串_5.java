package leetcode;

public class 最长回文子串_5 {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int max=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            int s1=judge(s,i,i);//奇数情况
            int s2=judge(s,i,i+1);//偶数情况
            int len=s1>s2?s1:s2;
            if(max<len){
                max=len;
                ans=s.substring(i-(max-1)/2,i+max/2+1);
            }
        }
        return ans;
    }
    public int judge(String s,int i,int j){
        while(i>=0&&j<s.length()&&i<=j&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
