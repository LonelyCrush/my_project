package com.xzit.wanger.juc.pc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leizefeng
 */
public class ProducerAndConsumerDemo {

    // 消费线程池
    private ThreadPoolExecutor executor;

    // 消息队列
    private LinkedBlockingQueue<String> messageQueue;

    private ProducerAndConsumerDemo setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
        return this;
    }

    private ProducerAndConsumerDemo setMessageQueue(LinkedBlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
        return this;
    }

    // 单例模式
    private ProducerAndConsumerDemo() {
    }

    private static ProducerAndConsumerDemo instance = new ProducerAndConsumerDemo(
    );

    public static ProducerAndConsumerDemo getInstance() {
        instance.setExecutor(new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10)));
        instance.setMessageQueue(new LinkedBlockingQueue<>(10));
        return instance;
    }

    public void initConsumer(ProducerAndConsumerDemo demo) {
        ThreadPoolExecutor executor = demo.executor;
        LinkedBlockingQueue<String> messageQueue = demo.messageQueue;
        executor.execute(() -> {
            synchronized (messageQueue) {
                while (messageQueue.isEmpty()) {
                    try {
                        messageQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consume message: " + messageQueue.poll());
            }
        });
    }

    public void sendMessage(ProducerAndConsumerDemo demo, String message) {
        LinkedBlockingQueue<String> messageQueue = demo.messageQueue;
        executor.execute(() -> {
            synchronized (messageQueue) {
                if (messageQueue.size() >= 10) {
                    try {
                        messageQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                messageQueue.offer(message);
                messageQueue.notifyAll();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumerDemo demo = getInstance();
        demo.initConsumer(demo);
        for (int i = 0; i < 10; i++) {
            System.out.println("send message: " + "message-" + i);
            demo.sendMessage(demo, "message-" + i);
            Thread.sleep(5000);
        }
    }
}
