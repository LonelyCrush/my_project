package com.xzit.demo.rabbit_mq.simple_mode.config;

import com.xzit.demo.rabbit_mq.constant.Constant;
import com.xzit.demo.rabbit_mq.simple_mode.role.SimpleReceiver;
import com.xzit.demo.rabbit_mq.simple_mode.role.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SimpleConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue(Constant.SIMPLE_QUEUE);
    }

    @Bean
    public SimpleSender simpleSender() {
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver() {
        return new SimpleReceiver();
    }
}
