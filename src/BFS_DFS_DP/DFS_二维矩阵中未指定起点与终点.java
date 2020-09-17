package BFS_DFS_DP;

import java.util.Scanner;

public class DFS_二维矩阵中未指定起点与终点 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.valueOf(sc.nextLine());
        for(int i=0;i<T;i++){
            String s1=sc.nextLine();
            String strings[]=s1.split(" ");
            boolean flag=false;
            int nn=Integer.valueOf(strings[0]);
            int mm=Integer.valueOf(strings[1]);
            char grid[][]=new char[nn][mm];
            for(int j=0;j<nn;j++){
                grid[j]=sc.nextLine().toCharArray();
            }
            boolean t[][]=new boolean[nn][mm];
            int x=0;
            for(int p=0;p<nn;p++){
                for(int q=0;q<mm;q++){
                    if(grid[p][q]=='S'){
                        if(dfs(p,grid,t,q)){
                            System.out.println("YES");
                            x=1;
                            break;
                        }
                    }
                }
                if(x==1){
                    break;
                }
            }
            if(x==1){
                System.out.println("NO");
            }
        }
    }
    public static boolean dfs(int p,char[][]grid,boolean t[][],int q){
        if(p<0||q<0||p>=grid.length||q>=grid[0].length||grid[p][q]=='#'||t[p][q]){
            return false;
        }
        if(grid[p][q]=='E'){
            return true;
        }
        if(t[p][q]==false){
            t[p][q]=true;
            return dfs(p+1,grid,t,q)||dfs(p,grid,t,q+1)||
                    dfs(p-1,grid,t,q)||dfs(p,grid,t,q-1);
        }
        return false;
    }
}
