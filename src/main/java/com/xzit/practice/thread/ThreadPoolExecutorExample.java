package com.xzit.practice.thread;

import lombok.AllArgsConstructor;

import java.util.concurrent.*;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-04-25 21:21
 */
public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        // 线程池配置
        int corePoolSize = 5; // 核心线程数
        int maximumPoolSize = 10; // 最大线程数
        long keepAliveTime = 60L; // 空闲线程存活时间，单位：秒
        TimeUnit unit = TimeUnit.SECONDS; // 时间单位
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100); // 工作队列
//        ThreadFactory threadFactory = Executors.defaultThreadFactory(); // 线程工厂
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy(); // 拒绝策略

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize,
                keepAliveTime, unit,
                workQueue
        );

        // 提交任务到线程池
        for (int i = 0; i < 20; i++) {
            Runnable worker = new WorkerThread("i am thread-" + i);
            executor.execute(worker);
        }

        // 关闭线程池（通常不建议立即关闭，而是等待所有任务完成）
        // executor.shutdown(); // 不再接受新任务，等待已提交任务执行完毕
        // executor.shutdownNow(); // 尝试停止所有正在执行的任务，暂停处理正在等待的任务，并返回等待执行的任务列表

        // 为了示例简单，这里我们只是简单等待一段时间让任务执行完成
        try {
            Thread.sleep(10000); // 假设所有任务在10秒内可以完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出线程池状态
        System.out.println("线程池状态: " + executor.getPoolSize() + " active threads, " + executor.getQueue().size() + " tasks in queue");

        // 关闭线程池（如果需要的话）
        executor.shutdown(); // 正常关闭
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // 等待一段时间后强制关闭
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // 如果有中断发生，也强制关闭
        }
    }

    @AllArgsConstructor
    static class WorkerThread implements Runnable {

        private final String command;

        @Override
        public void run() {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(Thread.currentThread().getName() + " 开始执行命令！");
            processCommand(command);
            System.out.println(Thread.currentThread().getName() + " 结束执行命令！");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }

        private void processCommand(String command) {
            try {
                System.out.println(command);
                Thread.sleep(2000); // 模拟任务执行时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
