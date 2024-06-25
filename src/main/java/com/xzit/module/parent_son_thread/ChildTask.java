package com.xzit.module.parent_son_thread;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * <p>
 * 该类用于：单个异步任务的执行
 * </p>
 *
 * @author leizf
 * @since 2024-05-08 21:00
 */
@Data
public class ChildTask {

    private final int POOL_SIZE = 3; // 线程池大小
    private final int SPLIT_SIZE = 4; // 数据拆分大小
    private String taskName;
    protected volatile boolean terminal = false; // 接收jvm关闭信号，实现优雅停机

    public ChildTask(String taskName) {
        this.taskName = taskName;
    }

    public void doExecute() {
        int i = 0;
        while (true) {
            System.out.println(taskName + ":Cycle-" + i + "-Begin");
            // 1、获取数据
            List<Cat> data = queryData();
            // 2、处理数据
            taskExecute(data);
            System.out.println(taskName + ":Cycle-" + i + "-End");
            if (terminal) {
                break;
            }
            i++;
        }
        // 回收线程池资源
        TaskProcessUtil.releaseExecutors(taskName);
    }

    /**
     *  获取数据
     */
    private List<Cat> queryData() {
        List<Cat> data = new ArrayList<>();
        for (int i = 1; i <= 5; i ++) {
            data.add(new Cat().setCatName("罗小黑" + i + "号"));
        }
        return data;
    }

    /**
     *  执行单个异步任务
     * @param data 原始数据
     */
    private void taskExecute(List<Cat> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        // 1、将数据拆成4份，计数器记录
        List<List<Cat>> partData = Lists.partition(data, SPLIT_SIZE);
        final CountDownLatch latch = new CountDownLatch(partData.size());
        // 2、用一个线程池去处理拆分的数据
        for (final List<Cat> item : partData) {
            ExecutorService executorService = TaskProcessUtil.getOrInitExecutors(taskName, POOL_SIZE);
            executorService.submit(() -> partDataExecutor(item, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  执行子任务
     * @param data 分批次后的数据
     * @param latch 计数器
     */
    private void partDataExecutor(List<Cat> data, CountDownLatch latch) {
        try {
            for (Cat item : data) {
                System.out.println(taskName + ": " + item.toString()
                        + ", ThreadName: " + Thread.currentThread().getName());
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    /**
     *  优雅停机
     */
    public void terminal() {
        // 关机
        terminal = true;
        System.out.println(taskName + "shut down");
    }
}
