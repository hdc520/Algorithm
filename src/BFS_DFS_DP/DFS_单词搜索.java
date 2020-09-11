package BFS_DFS_DP;

public class DFS_单词搜索 {
    public boolean exist(char[][] board, String word) {
        if(board.length==0||word.length()==0){
            return false;
        }
        boolean visited[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,visited,0)){
                    return true;
                }
            }
        }
        return false;
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
