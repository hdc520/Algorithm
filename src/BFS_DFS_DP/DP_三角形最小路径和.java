package BFS_DFS_DP;

import java.util.List;

public class DP_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;

        int dp[][]=new int[len][len];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {
            int n =  triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(0);
                }  else if (j == n - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int minNums = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int val = dp[len - 1][i];
            if (minNums > val) minNums = val;
        }
        return minNums;
    }
}
