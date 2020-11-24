package leetcode;

import java.util.*;

public class A_22_括号生成 {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder track=new StringBuilder();
        int left=0,right=0;
        dfs(track,left,right,n);
        return ans;
    }

    public void dfs(StringBuilder track,int left,int right,int n){
        if(left>n||right>n){
            return;
        }
        if(left==n&&right==n){
            ans.add(new String(track.toString()));
            return;
        }
        if(left>=right){
            track.append('(');
            dfs(track,left+1,right,n);
            track.replace(track.length()-1,track.length(),"");
            track.append(')');
            dfs(track,left,right+1,n);
            track.replace(track.length()-1,track.length(),"");
        }
    }
}
class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }
    private void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
