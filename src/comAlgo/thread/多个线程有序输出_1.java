package comAlgo.thread;

class Res1{
    char flag = 'A' ;
}

class A extends Thread{

    Res1 res;
    public A(Res1 res) {
        this.res=res;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (res.flag == 'A') {
                    System.out.println("A");
                    res.flag='B';
                    res.notifyAll();
                }else {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            return;
        }

    }

}



class B extends Thread{
    Res1 res;
    public B(Res1 res) {
        this.res=res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (res.flag == 'B') {
                    System.out.println("B");
                    res.flag='C';
                    res.notifyAll();
                }else {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
    }

}



class C extends Thread{
    Res1 res;
    public C(Res1 res) {
        this.res=res;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (res.flag == 'C') {
                    System.out.println("C");
                    res.flag='D';
                }else {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
    }

}

public class 多个线程有序输出_1 {
    public static void main(String[] args) {
        Res1 res1 = new Res1();
        A a = new A(res1);
        B b = new B(res1);
        C c = new C(res1);
        a.start();
        b.start();
        c.start();
    }
}
