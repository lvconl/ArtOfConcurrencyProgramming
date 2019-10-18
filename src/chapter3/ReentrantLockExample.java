package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock分析内存锁语义实现
 * @author lyuconl
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader() {
        lock.lock();
        try {
            int i = a;
            System.out.println(i);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.writer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.reader();
            }
        });
        t2.start();
        t1.start();
    }
}
