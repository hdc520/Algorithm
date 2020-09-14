package DSF;

import java.util.Arrays;
import java.util.Comparator;

public class 并查集_1 {
    static int nums[]=new int[10];
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            nums[i]=i;
        }
        System.out.println("----------初始数组----------");
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("连接5，6");
        unionElement(5,6);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("连接2，3");
        unionElement(2,3);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("合并2，3，5，6");
        unionElement(2,5);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void unionElement(int firstElement,int secondElement){
        int firstRoot=findRoot(firstElement);
        int secondRoot=findRoot(secondElement);
        if(firstRoot==secondRoot){
            return;
        }
        nums[firstRoot]=secondRoot;
    }
    public static int findRoot(int element){
        while(element!=nums[element]){
            int temp=nums[element];
            nums[element]=nums[temp];
            element=temp;
        }
        return element;
    }
    public boolean isConnected(int firstElement, int secondElement) {
        return findRoot(firstElement) == findRoot(secondElement);
    }
}
