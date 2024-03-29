package chapter3;

/**
 * final域重排序示例
 */
public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;

    FinalExample() {
        i = 1;
        j = 2;
    }

    public static void writer() {
        obj = new FinalExample();
    }

    public static void reader() {
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }
}
