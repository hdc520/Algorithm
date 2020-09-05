package leetcode;

import java.util.Stack;

class node{
    char c;
    int index;
    public node(char c,int i){
        this.c=c;
        this.index=i;
    }
}
public class A_32_最长有效括号 {
    /*
    括号题目的类似解法，与判断有效括号思路差不多。
     */
    public int longestValidParentheses(String s) {
        Stack<node> stack=new Stack<>();
        int Mark[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(new node(s.charAt(i),i));
            }else if(stack.peek().c=='('&&s.charAt(i)==')'){
                stack.pop();
            }else{
                stack.push(new node(s.charAt(i),i));
            }
        }
        while(!stack.isEmpty()){
            node p=stack.pop();
            System.out.print(p.c+" ");
            Mark[p.index]=1;
        }
        System.out.println();
        int max=0,count=0;
        for(int i=0;i<Mark.length;i++){
            System.out.print(Mark[i]+" ");
            if(Mark[i]==0){
                count++;
                max=Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }
}
