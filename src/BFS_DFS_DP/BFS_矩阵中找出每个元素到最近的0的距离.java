package BFS_DFS_DP;

import java.util.*;

public class BFS_矩阵中找出每个元素到最近的0的距离 {
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int grid[][]=new int[m][n];
        int visited[][]=new int[m][n];
        int X[]=new int[]{1, -1, 0, 0};
        int Y[]=new int[]{0, 0, 1, -1};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }
        while(!queue.isEmpty()){
            int []point=queue.poll();
            for(int p=0;p<X.length;p++){
                int new_x=point[0]+X[p];
                int new_y=point[1]+Y[p];;
                if(new_x<0||new_y<0||new_x>=m||new_y>=n||visited[new_x][new_y]==1){
                    continue;
                }
                queue.offer(new int[]{new_x,new_y});
                grid[new_x][new_y]=grid[point[0]][point[1]]+1;
                visited[new_x][new_y]=1;
            }
        }
        return grid;
    }
}
