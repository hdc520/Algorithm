package comAlgo.graph;

import java.util.*;

public class 利用拓扑排序判断有向图是否存在环 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDegree[]=new int[numCourses];
        int count=0;
        for(int []p:prerequisites){
            inDegree[p[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        if(queue.isEmpty()){
            return false;
        }
        int visited[]=new int[numCourses];
        while(!queue.isEmpty()){
            int cur=queue.poll();
            visited[cur]=1;
            count++;
            for(int p[]:prerequisites){
                if(p[1]==cur){
                    inDegree[p[0]]--;
                }
                if(inDegree[p[0]]==0&&visited[p[0]]==0){
                    queue.offer(p[0]);
                }
            }
        }
        return count==numCourses;
    }
}
