package com.xzit.module.parent_son_thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.*;

/**
 * <p>
 * 该类用于：管理线程池的工具类
 * </p>
 *
 * @author leizf
 * @since 2024-05-08 20:20
 */
public class TaskProcessUtil {

    // 每个任务，都有自己单独的线程池
    private static final Map<String, ExecutorService> executors = new ConcurrentHashMap<>();

    /**
     *  初始化一个线程池的方法
     * @param poolName 线程池的名字
     * @param poolSize 线程池的核心线程数和最大线程数
     */
    private static ExecutorService init(String poolName, int poolSize) {
        return new ThreadPoolExecutor(
                poolSize, poolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder()
                        .setNameFormat("Pool-" + poolName)
                        // 默认false，表示是否为守护线程
                        // 守护线程会随着主方法的结束而结束
//                        .setDaemon(false)
                        .build(),
                // 只要线程池未关闭，该策略直接在调用者线程中，运行当前的被丢弃的任务
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    /**
     *  获取一个线程池的方法
     * @param poolName 线程池的名字
     * @param poolSize 线程池的核心线程数和最大线程数
     */
    public static ExecutorService getOrInitExecutors(String poolName, int poolSize) {
        // 获取线程池可能会存在并发情况
        ExecutorService executorService = executors.get(poolName);
        if (executorService == null) {
            synchronized (TaskProcessUtil.class) {
                executorService = executors.get(poolName);
                if (executorService == null) {
                    executorService = init(poolName, poolSize);
                    executors.put(poolName, executorService);
                }
            }
        }
        return executorService;
    }

    /**
     *  回收线程池资源
     * @param poolName 线程池的名字
     */
    public static void releaseExecutors(String poolName) {
        ExecutorService executorService = executors.remove(poolName);
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
