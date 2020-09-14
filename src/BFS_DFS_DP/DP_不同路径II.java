package BFS_DFS_DP;

public class DP_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int DP[][]=new int[m][n];
        int X[]=new int[]{0,-1};
        int Y[]=new int[]{-1,0};
        DP[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<2;p++){
                    int x_new=i+X[p];
                    int y_new=j+Y[p];
                    if(x_new<0||y_new<0||x_new>=m||y_new>=n||obstacleGrid[i][j]==1){
                        continue;
                    }
                    DP[i][j]+=DP[x_new][y_new];
                }
            }
        }
        return DP[m-1][n-1];
    }
}
