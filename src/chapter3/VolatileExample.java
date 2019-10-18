package chapter3;

/**
 * volatile关键字
 * @author lyuconl
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag= true;
    }

    public void reader() {
        if (flag) {
            int i = a;
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExample.writer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExample.reader();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
