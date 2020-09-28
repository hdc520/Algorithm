package comAlgo.graph;

import java.util.*;

public class 利用拓扑排序判断有向图是否存在环 {
    //不构造邻接表，使用数组标志量
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
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

    //使用邻接表做法
    // 判断图是否有环，利用图节点的出度来计算
    // 构造邻接表来存储图，List<Integer>[] graphic = new List[numCourses];
    // 利用入度矩阵存储每个节点的入度
    // 将入度为0的节点一次入队，然后遍历，减少其对应端点的入度
    // 最后判断是否全部入队
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.根据边的关系来构造图
        List<Integer>[] graphic = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            graphic[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites){
            graphic[pre[0]].add(pre[1]);
        }
        // 2.创建入度表
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            List<Integer> pre = graphic[i];
            for(int num : pre)
                inDegree[num] += 1;
        }
        // 3.入度为0的节点入队，然后bfs求解
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            numCourses --;
            for(int num : graphic[temp]){
                inDegree[num] -= 1;
                if(inDegree[num] == 0)
                    queue.offer(num);
            }
        }
        return numCourses == 0;
    }
}
