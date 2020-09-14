package DSF;

import java.util.Arrays;
import java.util.Comparator;

class Union {
    int count;//树的个数
    int[] root;//每个点的根节点
    int[] size;//一棵树的节点数

    Union(int m) {
        root = new int[m];
        size = new int[m];
        for (int i = 0; i < m; i++) {
            root[i] = i;//初始点，每个点的根节点都是自己
            size[i] = 1;//每棵树只有1个节点
        }
        count = m;//总共有m棵树
    }

    public void unionF(int i, int j) {
        int x = find(i);//i的根节点
        int y = find(j);//j的根节点
        if (x != y) {
            if (size[x] > size[y]) {//x树更大，把y接上去
                root[y] = x;
                size[y] += size[x];
            } else {//y树更大，把x接上去
                root[x] = y;
                size[x] += size[y];
            }
            count--;
        }
    }

    public int find(int j) {
        while (root[j] != j) {
            //这句是为了压缩路径，不要的话可以跑的通，但效率变低
            root[j] = root[root[j]];
            j = root[j];
        }
        return j;
    }

    public int count() {
        return count;
    }

    public boolean connected(int i, int j) {
        int x = find(i);
        int y = find(j);
        return x == y;
    }
}
public class 并查集求_最短路径 {
    public int minimumCost(int N, int[][] connections) {
        if (N <= 1)
            return -1;
        if (connections.length < N - 1)//边数量小于点-1，不可能构成树
            return -1;
        Arrays.sort(connections, Comparator.comparingInt(t -> t[2]));//按权重排序
        Union u = new Union(N);
        int count = 1;
        int res = 0;
        for (int[] connect : connections) {
            if (u.connected(connect[0] - 1, connect[1] - 1))//两点曾经连接过，没必要再连
                continue;
            u.unionF(connect[0] - 1, connect[1] - 1);
            count++;
            res += connect[2];
            if (count == N)//所有点都连上了
                return res;
        }
        return -1;
    }
}
