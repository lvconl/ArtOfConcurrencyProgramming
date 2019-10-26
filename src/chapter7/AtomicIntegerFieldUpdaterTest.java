package chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段测试
 * @@author lyuconl
 */
public class AtomicIntegerFieldUpdaterTest {
    /**
     * 创建原子更新类
     */
    private static final AtomicIntegerFieldUpdater<User> atomicUpdater =
            AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        // 设置柯南年龄十岁
        User conan = new User("conan", 17);
        // 柯南长了一岁,但是仍然输出旧的年龄
        System.out.println(atomicUpdater.getAndIncrement(conan));
        // 输出柯南新的年龄
        System.out.println(atomicUpdater.get(conan));
    }

    public static class User {
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}
