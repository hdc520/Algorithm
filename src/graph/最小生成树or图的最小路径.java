package graph;

import java.util.*;

public class 最小生成树or图的最小路径 {
    public static void main(String[] args) {
        int connections[][]=new int[][]{{1,2,5},{1,3,6},{2,3,1},{4,2,3}};
        //记得判断边数与N的大小。
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int [] connect:connections){
            if(map.containsKey(connect[0])){
                int endCost[]=new int[]{connect[1],connect[2]};
                List<int[]>path=map.get(connect[0]);
                path.add(endCost);
                map.put(connect[0],path);
            }else{
                int endCost[]=new int[]{connect[1],connect[2]};
                List<int[]>path=new ArrayList<>();
                path.add(endCost);
                map.put(connect[0],path);
            }if(map.containsKey(connect[1])){
                int startCost[]=new int[]{connect[0],connect[2]};
                List<int[]>path=map.get(connect[1]);
                path.add(startCost);
                map.put(connect[1],path);
            }else{
                int startCost[]=new int[]{connect[0],connect[2]};
                List<int[]>path=new ArrayList<>();
                path.add(startCost);
                map.put(connect[1],path);
            }
        }
        boolean visited[]=new boolean[connections.length];
        //任意取起始点
        int start=connections[0][0];
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]){
                    return -1;
                }
                return 1;
            }
        });
        int ans=0,count=0;
        visited[start-1]=true;
        priorityQueue.addAll(map.get(start));
        while(!priorityQueue.isEmpty()){
            int []temp=priorityQueue.poll();
            if(visited[temp[0]-1]){
                continue;
            }
            priorityQueue.addAll(map.get(temp[0]));
            visited[temp[0]-1]=true;
            count++;
            ans+=temp[1];
            if(count==connections.length){
                break;
            }
        }
        System.out.println(count+" "+ans);
    }
}
