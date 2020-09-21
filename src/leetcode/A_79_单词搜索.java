package leetcode;

import java.util.ArrayList;
import java.util.List;

public class A_79_单词搜索 {
    static boolean flag=false;
    public static void main(String[] args) {
        char board[][]=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,""));
    }
    public static boolean exist(char[][] board, String word) {
        List<Character>track=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                backTrack(board,word,track,i,j,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public static void backTrack(char[][] board, String word, List<Character> track, int i, int j, int index) {
        if(track.size()==word.length()||flag==true){
            flag=true;
            return;
        }
        if(i<0||j<0||i>=board.length||j>=board[i].length){
            return;
        }
       if(board[i][j]==word.charAt(index)){
           track.add(word.charAt(index));
           backTrack(board,word,track,i-1,j,index+1);
           backTrack(board,word,track,i,j-1,index+1);
           backTrack(board,word,track,i+1,j,index+1);
           backTrack(board,word,track,i,j+1,index+1);
           track.remove(track.size()-1);
       }else{
           return;
       }
    }
    public boolean dfs(char[][] board,String word,int i,int j,boolean visited[][],int index){
        if(index==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index)||visited[i][j]){
            return false;
        }
        if(visited[i][j]==false){
            visited[i][j]=true;
            if(dfs(board,word,i,j-1,visited,index+1)||dfs(board,word,i-1,j,visited,index+1)||
                    dfs(board,word,i,j+1,visited,index+1)||dfs(board,word,i+1,j,visited,index+1)){
                return true;
            }
            visited[i][j]=false;
        }
        return false;
    }
}
