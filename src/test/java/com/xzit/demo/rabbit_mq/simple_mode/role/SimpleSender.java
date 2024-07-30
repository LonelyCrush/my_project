package com.xzit.demo.rabbit_mq.simple_mode.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

public class SimpleSender {

    private static final Logger logger = LoggerFactory.getLogger(SimpleSender.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE_NAME = "simple_queue";

    public void send(String message) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
        logger.info("Sender -> : " + message);
    }
}
