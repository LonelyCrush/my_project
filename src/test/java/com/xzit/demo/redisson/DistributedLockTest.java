package com.xzit.demo.redisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

@SpringBootTest
@Slf4j
public class DistributedLockTest {

    @Resource
    private RedissonClient redissonClient;

    private int result;

    @Test
    public void testDistributedLock() throws InterruptedException {
        int count = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                Lock lock = redissonClient.getLock("DistributedLock");
                try {
                    lock.lock();
                    result += 1;
                } finally {
                    lock.unlock();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        log.info("Result: {}", result);
    }
}
