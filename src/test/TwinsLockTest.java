package test;

import chapter5.TwinsLock;
import util.SleepUtil;

import java.util.concurrent.locks.Lock;

/**
 * TwinsLock测试
 * @author lyuconl
 */
public class TwinsLockTest {
    public static void main (String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtil.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtil.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i < 10; i++) {
            SleepUtil.second(1);
            System.out.println();
        }
    }
}
