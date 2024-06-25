package com.xzit.practice.rocketMq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-06-17 10:32
 */
public class RocketMQReceiveTest {

    public static void main(String[] args) throws Exception {
        // 创建消息消费者, 指定消费者所属的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer617");

        // 指定Nameserver地址
        consumer.setNamesrvAddr("192.168.27.129:9876");

        // 指定消费者订阅的主题和标签
        consumer.subscribe("topic617-1", "*");

        // 设置回调函数，编写处理消息的方法
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                // 消费逻辑
                ConsumerToDo.consumerToDo();

                // 返回消费状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消息消费者
        consumer.start();

        System.out.println("Consumer Started.");
    }
}
