package comAlgo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 多个线程顺序轮流打印 {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        //使用ReentrantLock的newCondition()方法创建Condition，分别对应三个线程
        Condition conditionA=lock.newCondition();
        Condition conditionB=lock.newCondition();
        Condition conditionC=lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for(int i=0;i<10;i++){
                        System.out.println("A");
                        conditionB.signal();
                        conditionA.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for(int i=0;i<10;i++){
                        System.out.println("B");
                        conditionC.signal();
                        conditionB.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for(int i=0;i<10;i++){
                        System.out.println("C");
                        conditionA.signal();
                        conditionC.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
