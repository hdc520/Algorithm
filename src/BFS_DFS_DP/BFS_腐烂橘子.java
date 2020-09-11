package BFS_DFS_DP;

import java.util.*;

public class BFS_腐烂橘子 {
    public int orangesRotting(int[][] grid) {
        int min=0;
        int X[]=new int[]{1,-1,0,0};
        int Y[]=new int[]{0,0,1,-1};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int queue_length=queue.size();
            System.out.println(queue_length);
            for(int i=0;i<queue_length;i++){
                int []temp=queue.poll();
                for(int j=0;j<X.length;j++){
                    int x=temp[0]+X[j];
                    int y=temp[1]+Y[j];
                    if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1){
                        grid[x][y]=2;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            if(!queue.isEmpty()){
                min++;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return min;
    }
}
