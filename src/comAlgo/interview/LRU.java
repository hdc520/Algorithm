package comAlgo.interview;
import java.util.*;

public class LRU {
    static Map<Integer,Node> map;
    static int size;
    static int cap;
    static Deque<Node> list;
    public LRU(int cap){
        this.cap=cap;
        this.size=0;
        map=new HashMap<>();
        list=new LinkedList<>();
    }
    public static int get(int key){
        Node p=null;
        if(map.containsKey(key)){
            p=map.get(key);
            list.remove(p);
            list.addFirst(p);
            return p.value;
        }else{
            return -1;
        }
    }

    public static void put(int k,int v){
        Node p=new Node(k,v);
        if(map.containsKey(k)){
            Node temp=map.get(k);
            map.remove(k);
            list.remove(temp);
            map.put(k,p);
            list.addFirst(p);
            return;
        }else{
            map.put(k,p);
            list.addFirst(p);
            size++;
            if(size>cap){
                Node node=list.removeLast();
                map.remove(node.key);
                size--;
            }
        }
    }
    public static void main(String[] args) {
        LRU cache=new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));   // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
