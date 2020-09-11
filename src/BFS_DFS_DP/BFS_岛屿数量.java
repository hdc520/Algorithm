package BFS_DFS_DP;

import java.util.*;

public class BFS_岛屿数量 {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int X[]=new int[]{0,0,-1,1};
        int Y[]=new int[]{1,-1,0,0};
        int visited[][]=new int[m][n];
        int count=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=1;
                    count++;
                    while(!queue.isEmpty()){
                        int point[]=queue.poll();
                        for(int p=0;p<X.length;p++){
                            int new_x=point[0]+X[p];
                            int new_y=point[1]+Y[p];
                            if(new_x<0||new_y<0||new_x>=m||new_y>=n||visited[new_x][new_y]==1||grid[new_x][new_y]=='0'){
                                continue;
                            }
                            queue.offer(new int[]{new_x,new_y});
                            visited[new_x][new_y]=1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
