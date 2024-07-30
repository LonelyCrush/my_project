package com.xzit.demo.rabbit_mq.simple_mode.role;

import com.xzit.demo.rabbit_mq.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = Constant.SIMPLE_QUEUE)
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String message) {
        log.info("Receiver <- : {}", message);
    }
}
