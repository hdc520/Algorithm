package BFS_DFS_DP;

//1 3 5 9
//8 1 3 4
//5 0 6 1
//8 8 4 0
public class DP_最短路径 {
    public int minPathSum(int[][] grid) {
        int DP[][]=new int[grid.length][grid[0].length];
        DP[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++){
            DP[i][0]=DP[i-1][0]+grid[i][0];
        }
        for(int j=1;j<grid[0].length;j++){
            DP[0][j]=DP[0][j-1]+grid[0][j];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                DP[i][j]=Math.min(DP[i-1][j],DP[i][j-1])+grid[i][j];
            }
        }
        return DP[grid.length-1][grid[0].length-1];
    }
}
