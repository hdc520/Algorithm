package leetcode;

import java.util.*;

public class A_118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            List<Integer> levelList=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
                levelList.add(arr[i][j]);
            }
            ans.add(levelList);
        }
        return ans;
    }
}
