package util;

import java.util.concurrent.TimeUnit;

/**
 * 线程睡眠工具类
 * @author lyuconl
 */
public class SleepUtil {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
