package com.xzit.wanger.juc.scheduled;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leizefeng
 */
@SpringBootTest
public class ScheduledExecutorTest {

    private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

    Runnable runnable = () -> {
        if (messageNeededToSend()) {
            System.out.println(DateUtil.format(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss") + ": Sending message");
            try {
                Thread.sleep(1000); // 模拟发送消息的耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 上一个任务完成之后延迟一定时间开始下一个任务
     * @throws InterruptedException
     */
    @Test
    public void testScheduleWithFixedDelay() throws InterruptedException {
        executor.scheduleWithFixedDelay(runnable, 2, 2, TimeUnit.SECONDS);
        Thread.sleep(20000);
    }

    /**
     * 以固定的某个频率开始每一个任务，不关心任务的耗时长短
     * @throws InterruptedException
     */
    @Test
    public void testScheduleAtFixedRate() throws InterruptedException {
        executor.scheduleAtFixedRate(runnable, 2, 2, TimeUnit.SECONDS);
        Thread.sleep(20000);
    }

    private boolean messageNeededToSend() {
        // 查询数据库，有没有当前时间需要发送的消息
        // 这里省略实现，直接返回true
        return true;
    }
}
