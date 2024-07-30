package com.xzit.demo.rabbit_mq.work_mode.role;

import com.xzit.demo.rabbit_mq.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

@Slf4j
public class WorkSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(int index) {
        StringBuilder stringBuilder = new StringBuilder(index);
        int remainder = index % 3 + 1;
        for (int i = 0; i < remainder; i++) {
            stringBuilder.append(".");
        }
        String message = stringBuilder.toString();

        rabbitTemplate.convertAndSend(Constant.WORK_QUEUE, message);
        log.info("Sender -> : {}", message);
    }
}
