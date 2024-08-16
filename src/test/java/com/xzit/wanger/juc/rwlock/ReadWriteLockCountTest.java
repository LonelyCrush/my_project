package com.xzit.wanger.juc.rwlock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leizefeng
 */
@SpringBootTest
public class ReadWriteLockCountTest {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();

    private final Lock w = rwl.writeLock();

    private int count = 0;

    @Test
    public void testReadLockAndConcurrent() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        for (int j = 0; j < 10; j++) {
            threadPoolExecutor.execute(() -> {
                incrementCount();
                System.out.print(getCount() + " ");
            });
        }
//        for (int j = 0; j < 10; j++) {
//            threadPoolExecutor.execute(() -> {
//                incrementCountByLock();
//                System.out.print(getCountByLock() + " ");
//            });
//        }
    }

    private int getCount() {
        return count;
    }

    private void incrementCount() {
        count++;
    }

    private int getCountByLock() {
        r.lock();
        try {
            return count;
        } finally {
            r.unlock();
        }
    }

    private void incrementCountByLock() {
        w.lock();
        try {
            count++;
        } finally {
            w.unlock();
        }
    }
}
