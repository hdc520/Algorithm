package comAlgo.thread;

public class deadLock {
    private static String a="a";
    private static String b="b";
    public void methodA()  {
        synchronized (a){
            System.out.println("进入a");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println("进入b");
            }
        }
    }
    public void methodB() {
        synchronized (b){
            System.out.println("进入b");
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (a){
                System.out.println("进入a");
            }
        }
    }

    public static void main(String[] args) {
        deadLock d=new deadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.methodA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.methodB();
            }
        }).start();
    }
}
