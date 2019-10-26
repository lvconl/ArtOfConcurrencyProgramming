package chapter8;

import java.util.concurrent.CyclicBarrier;

/**
 * 设置拦截线程的优先级
 * 用于在线程到达屏障时，优先处理Action
 * @author lyuconl
 */
public class CyclicBarrierTestTwo {
    static class Action implements Runnable {
        @Override
        public void run() {
            System.out.println("Action");
        }
    }
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Action());

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        });
        thread.start();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
