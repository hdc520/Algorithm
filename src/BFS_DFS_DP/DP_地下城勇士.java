package BFS_DFS_DP;

public class DP_地下城勇士 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int DP[][]=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1){
                    DP[i][j]=Math.max(1,1-dungeon[i][j]);
                }else if(i==m-1){
                    DP[i][j]=Math.max(1,DP[i][j+1]-dungeon[i][j]);
                }else if(j==n-1){
                    DP[i][j]=Math.max(1,DP[i+1][j]-dungeon[i][j]);
                }else{
                    DP[i][j]=Math.max(1,Math.min(DP[i][j+1],DP[i+1][j])-dungeon[i][j]);
                }
            }
        }
        return DP[0][0];
    }
}
