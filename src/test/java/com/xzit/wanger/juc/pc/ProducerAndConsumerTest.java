package com.xzit.wanger.juc.pc;

import kotlin.collections.ArrayDeque;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leizefeng
 */
public class ProducerAndConsumerTest {

    private static final ScheduledExecutorService executorP = new ScheduledThreadPoolExecutor(1);
    private static final ScheduledExecutorService executorC = new ScheduledThreadPoolExecutor(1);

    private static final List<String> messageQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        executorP.scheduleAtFixedRate(() -> {
            new Producer(messageQueue).start();
        }, 3, 3, TimeUnit.SECONDS);
        executorC.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Consumer(messageQueue).start();
        }, 3, 3, TimeUnit.SECONDS);
    }

    static class Producer extends Thread {

        private final List<String> lock;

        public Producer(List<String> lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                String threadName = Thread.currentThread().getName();
                System.out.println("------------------------------------");
                System.out.println(threadName + " producer start");
                System.out.println("add --> " + threadName);
                lock.add(threadName);
                System.out.println(threadName + " producer end");
                System.out.println(threadName + " notify all");
                lock.notifyAll();
            }
        }
    }

    static class Consumer extends Thread {

        private final List<String> lock;

        public Consumer(List<String> lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                String threadName = Thread.currentThread().getName();
                while (lock.isEmpty()) {
                    System.out.println("------------------------------------");
                    System.out.println(threadName + " list is empty, waiting...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " waiting end");
                }
                System.out.println("------------------------------------");
                System.out.println(threadName + " consumer start");
                System.out.println("remove --> " + lock.get(0));
                lock.remove(0);
                System.out.println(threadName + " consumer end");
            }
        }
    }
}
