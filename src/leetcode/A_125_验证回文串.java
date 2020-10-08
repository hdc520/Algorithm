package leetcode;

public class A_125_验证回文串 {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        StringBuilder s1=new StringBuilder();
        for(char c:s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                s1.append(c);
            }
        }
        int left=0,right=s1.toString().length()-1;
        while(left<=right){
            if(s1.toString().charAt(left)!=s1.toString().charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
