package chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子Integer类示例
 * @author lyuconl
 */
public class AtomicIntegerTest {
    private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
