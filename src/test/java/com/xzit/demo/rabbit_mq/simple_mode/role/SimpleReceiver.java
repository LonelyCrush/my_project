package com.xzit.demo.rabbit_mq.simple_mode.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

public class SimpleReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(String message) {
        logger.info("Receiver <- : " + message);
    }
}
