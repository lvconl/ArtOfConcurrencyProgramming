package chapter8;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest
 * @author lyuconl
 */
public class CountDownLatchTest {
    private static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                c.countDown();
            }
        });
        parser1.start();
        parser2.start();
        c.await();
        System.out.println(3);
    }
}
