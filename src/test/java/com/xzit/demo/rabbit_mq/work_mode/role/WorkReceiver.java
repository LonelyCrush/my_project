package com.xzit.demo.rabbit_mq.work_mode.role;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.thread.ThreadUtil;
import com.xzit.demo.rabbit_mq.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = Constant.WORK_QUEUE)
public class WorkReceiver {

    public final int number;

    public WorkReceiver(int number) {
        this.number = number;
    }

    @RabbitHandler
    public void receive(String message) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        doSomething(message);
        stopWatch.stop();
        log.info("This instance[{}], Receiver <- : {}, time : {}", number, message, stopWatch.getTotalTimeSeconds());
    }

    private void doSomething(String message) {
        for (char messageChar : message.toCharArray()) {
            if (messageChar == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
