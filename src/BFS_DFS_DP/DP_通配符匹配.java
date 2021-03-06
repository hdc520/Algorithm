package BFS_DFS_DP;

public class DP_通配符匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i < n+1; i++) {
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }

        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                char pc = p.charAt(j-1), sc = s.charAt(i-1);
                if(pc == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] && pc==sc;
                }
            }
        }
        return dp[m][n];
    }
}
