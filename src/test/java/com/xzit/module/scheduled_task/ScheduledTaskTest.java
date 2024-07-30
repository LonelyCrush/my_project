package com.xzit.module.scheduled_task;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ScheduledTaskTest {

    @Test
    public void test() {

    }

    @Test
    public void testScheduledThreadExecutor() throws InterruptedException {
        TimerTask command = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                printSomething();
            }
        };

        printSomething();

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
        long initialDelay = 2000L;
        long period = 1000L;
        threadPool.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.MILLISECONDS);
        Thread.sleep(period * 10);
        threadPool.shutdown();
    }

    private void printSomething() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("currentTime：" + date + " |------| threadName: " + Thread.currentThread().getName());
    }


}
