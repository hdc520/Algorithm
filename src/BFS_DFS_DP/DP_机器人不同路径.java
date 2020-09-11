package BFS_DFS_DP;

public class DP_机器人不同路径 {
    public int uniquePaths(int m, int n) {
        int X[]=new int[]{-1,0};
        int Y[]=new int[]{0,-1};
        int DP[][]=new int[m][n];
        DP[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<X.length;p++){
                    int new_x=i+X[p];
                    int new_y=j+Y[p];
                    if(new_x<0||new_y<0){
                        continue;
                    }
                    DP[i][j]+=DP[new_x][new_y];
                }
            }
        }
        return DP[m-1][n-1];
    }
}
