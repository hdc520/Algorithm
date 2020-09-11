package BFS_DFS_DP;

public class DFS_被环绕的区域 {
    class Solution {
        // 方向数组
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        public void solve(char[][] board) {
            // 边界值
            if (board == null || board.length == 0 || board[0].length == 0) return ;
            // 先把四周的O变为-（什么都行）
            // 第 1 列
            for (int i = 0 ,j = 0; i < board.length; ++i)
                if (board[i][j] == 'O') infect(board,i,j);
            // 最后一列
            for (int i = 0,j = board[0].length - 1; i < board.length ; ++i)
                if (board[i][j] == 'O') infect(board,i,j);
            // 第一行
            for (int j = 0,i = 0; j < board[0].length - 1; ++j)
                if (board[i][j] == 'O') infect(board,i,j);
            // 最后一行
            for (int j = 0,i = board.length - 1; j < board[0].length - 1; ++j)
                if (board[i][j] == 'O') infect(board,i,j);
            // 然后遍历一变，把剩余的O，都变为X，剩余的-都变为O
            for (int i = 0 ; i < board.length ; ++i){
                for (int j = 0 ; j < board[0].length ;++j){
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    else if (board[i][j] == '-') board[i][j] = 'O';
                }
            }
        }

        // 感染函数
        public void infect(char[][] board ,int i ,int j){
            // 结束条件
            if (board[i][j] == 'X' || board[i][j] == '-') return ;
            // 当前层逻辑
            if (board[i][j] == 'O')board[i][j] = '-';
            // 向四个方向递归，如果有一个方向是O，就下探
            for (int k = 0; k < dx.length ;++k){
                int nx = i + dx[k];  // 下一个x方向
                int ny = j + dy[k];  // 下一个y方向
                // 如果边界为 O,那这块区域就没有被包围，那就不算
                if (nx >= 0
                        && nx <= board.length - 1
                        && ny >= 0
                        && ny <= board[0].length - 1
                        && board[nx][ny] == 'O'){  // 如果不越界，并且这个方向是 O的话，就感染
                    infect(board,nx,ny);
                }
            }
        }
    }
}
