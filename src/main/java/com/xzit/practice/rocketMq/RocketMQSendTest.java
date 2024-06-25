package com.xzit.practice.rocketMq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;


/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-06-17 09:46
 */
public class RocketMQSendTest {

    public static void main(String[] args) throws Exception {
        // 创建生产者和指定组名
        DefaultMQProducer producer = new DefaultMQProducer("producer617");
        
        // 指定nameserver地址
        producer.setNamesrvAddr("192.168.27.129:9876");

        // 启动生产者
        producer.start();

        // 创建消息对象，指定主题、标签和消息体
        Message message = new Message("topic617-1", "tag617-1",
                ProducerToDo.producerToDo().getBytes());

        // 发送消息
        SendResult result = producer.send(message, 20000);
        System.out.println(result);

        // 关闭生产者
        producer.shutdown();

        System.out.println("Producer Started.");
    }
}
