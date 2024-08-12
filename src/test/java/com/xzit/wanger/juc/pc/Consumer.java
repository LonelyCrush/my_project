package com.xzit.wanger.juc.pc;

/**
 * @author leizefeng
 */
public class Consumer {

    public static void main(String[] args) {
        ProducerAndConsumerDemo demo = ProducerAndConsumerDemo.getInstance();
        demo.initConsumer(demo);
    }
}
