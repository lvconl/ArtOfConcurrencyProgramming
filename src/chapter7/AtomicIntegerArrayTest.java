package chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组测试
 * @author lyuconl
 */
public class AtomicIntegerArrayTest {
    private static int[] value = new int[] { 1, 2 };
    /**
     * AtomicIntegerArray的构造方法中将当前传入数组进行拷贝，修改ai中数组的值不会影响原来数组中的值
     */
    private static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
        ai.addAndGet(0, 1);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
