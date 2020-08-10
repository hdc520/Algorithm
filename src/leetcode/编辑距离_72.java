package leetcode;

public class 编辑距离_72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
    public static int minDistance(String word1, String word2) {
        int DP[][]=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++){
            DP[i][0]=i;
        }
        for(int j=0;j<word2.length()+1;j++){
            DP[0][j]=j;
        }
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    DP[i][j]=DP[i-1][j-1];
                }else{
                    DP[i][j]=1+Math.min(DP[i-1][j-1],Math.min(DP[i-1][j],DP[i][j-1]));
                }
            }
        }
        return DP[word1.length()][word2.length()];
    }
}
