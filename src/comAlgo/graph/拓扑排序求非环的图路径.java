package comAlgo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class 拓扑排序求非环的图路径 {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        int inDegree[]=new int[numCourses];
        int res[]=new int[numCourses];
        for(int []p:prerequisites){
            inDegree[p[0]]++;
        }
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        int index=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            count++;
            res[index++]=cur;
            for(int []p:prerequisites){
                if(p[1]==cur){
                    inDegree[p[0]]--;
                }
                if(inDegree[p[0]]==0){
                    queue.offer(p[0]);
                }
            }
        }
        return count==numCourses?res:new int[0];
    }
}
