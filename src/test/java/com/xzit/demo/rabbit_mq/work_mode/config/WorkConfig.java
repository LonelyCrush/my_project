package com.xzit.demo.rabbit_mq.work_mode.config;

import com.xzit.demo.rabbit_mq.work_mode.role.WorkSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WorkConfig {

    @Bean
    public WorkSender workSender() {
        return new WorkSender();
    }
}
