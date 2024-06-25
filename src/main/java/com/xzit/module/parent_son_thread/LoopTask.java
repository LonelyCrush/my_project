package com.xzit.module.parent_son_thread;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 该类用于：多个异步任务的执行
 * </p>
 *
 * @author leizf
 * @since 2024-05-08 21:30
 */
public class LoopTask {

    private List<ChildTask> childTasks;

    /**
     *  初始化并执行多个异步任务
     */
    public void initLoopTask() {
        childTasks = new ArrayList<>();
        childTasks.add(new ChildTask("childTask0"));
        childTasks.add(new ChildTask("childTask1"));

        for (final ChildTask item : childTasks) {
            new Thread(item::doExecute).start();
        }
    }

    /**
     *  关闭所有异步任务
     */
    public void shutdownLoopTask() {
        if (!CollectionUtils.isEmpty(childTasks)) {
            for (ChildTask item : childTasks) {
                item.terminal();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LoopTask loopTask = new LoopTask();
        loopTask.initLoopTask();
        Thread.sleep(5000L);
        loopTask.shutdownLoopTask();
    }
}
