package DSF;

public class 并查集_连通网络的操作次数 {
    //记住parent一定是全局变量
    int parent[];
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] connect:connections){
            union(connect[0],connect[1]);
        }
        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i){
                count++;
            }
        }
        return count-1;
    }
    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return;
        }
        parent[rootA]=rootB;
    }
    public int find(int a){
        while(a!=parent[a]){
            int temp=parent[a];
            parent[a]=parent[temp];
            a=temp;
        }
        return a;
    }
}
