package chapter4;

import chapter4.impl.ThreadPool;

/**
 * 线程池示例测试
 * @author lyuconl
 */
public class DefaultThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool<Task> tp = new DefaultThreadPool<>();
        int count = 10;
        for (int i = 0; i < count; i++) {
            tp.execute(new Task(i));
        }
    }
    static class Task implements Runnable {

        private int num;

        Task (int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("Task--" + num + "--running");
            try {
                Thread.sleep((int) (Math.random() * 5000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
