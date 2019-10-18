package chapter4.impl;

/**
 * 线程池接口
 * @author lyuconl
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行工作job
     * @param job 要执行job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num 增加的数目
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num 减少数目
     */
    void removeWorkers(int num);

    /**
     * 得到正在执行的任务数
     * @return 任务数
     */
    int getJobSize();
}
