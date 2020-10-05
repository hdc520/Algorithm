package comAlgo.thread;

public class 多个线程有序输出_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("t1");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t2");
                try {
                    t1.join();
//t.join()方法只会调用t.join()的线程进入等待池并等待t线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程。
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("B");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("C");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
