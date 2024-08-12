package com.xzit.wanger.juc.rwlock;

import com.xzit.practice.collection.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leizefeng
 */
@SpringBootTest
public class ReadWriteLockTest {

    // 读写锁
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // 锁操作的共享对象或者数据
    private Student student;

    // 共享对象或者数据是否存在，如果存在获取读锁使用即可，如果不存在则再获取写锁重建并锁降级之后使用即可
    private boolean dataExist;

    @Test
    public void testReadWriteLock() {
        for (int i = 0; i < 2; i++) {
            printStudent();
        }
    }

    @Test
    public void testReadLockAndConcurrent() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(this::printStudent);
        }
    }

    private void printStudent() {
        // 获取读锁
        lock.readLock().lock();
        try {
            if (dataExist) {
                System.out.println("===============>>");
                System.out.println("数据存在：");
            } else {
                // 释放读锁
                lock.readLock().unlock();
                // 获取写锁
                lock.writeLock().lock();
                try {
                    if (!dataExist) {
                        this.student = new Student("Tom", 18);
                        dataExist = true;
                        System.out.println("===============>>");
                        System.out.println("数据不存在，已重建：");
                    }
                } finally {
                    // 释放写锁
                    lock.writeLock().unlock();
                }
                // 获取写锁
                lock.writeLock().lock();
                try {
                    if (!dataExist) {
                        this.student = new Student("Tom", 18);
                        dataExist = true;
                        System.out.println("===============>>");
                        System.out.println("数据不存在，已重建：");
                    }
                    // 锁降级
                    lock.readLock().lock();
                } finally {
                    // 释放写锁
                    lock.writeLock().unlock();
                }
            }
            printStudent(student);
        } finally {
            // 释放读锁
            lock.readLock().unlock();
        }
    }

    private void printStudent(Student student) {
        Optional.ofNullable(student).ifPresent(s -> System.out.println("[" + Thread.currentThread().getName() + "][" + student + "]"));
    }
}
