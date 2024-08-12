package com.xzit.wanger.juc.pc;

/**
 * @author leizefeng
 */
public class Producer {

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumerDemo demo = ProducerAndConsumerDemo.getInstance();
        for (int i = 0; i < 10; i++) {
            demo.sendMessage(demo,"message-" + i);
            System.out.println("send message: " + "message-" + i);
            Thread.sleep(5000);
        }
    }
}
