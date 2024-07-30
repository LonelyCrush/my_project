package com.xzit.demo.rabbit_mq.simple_mode.role;

import com.xzit.demo.rabbit_mq.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

@Slf4j
public class SimpleSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(Constant.SIMPLE_QUEUE, message);
        log.info("Sender -> : " + message);
    }
}
