package com.xzit.demo.rabbit_mq.simple_mode.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.xzit.demo.rabbit_mq.simple_mode.role.SimpleSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @Resource
    private SimpleSender simpleSender;

    @GetMapping
    public String testSimpleMode() {
        for (int i = 0; i < 10; i++) {
            simpleSender.send("Hello Simple RabbitMQ! " + i);
            ThreadUtil.sleep(1000);
        }
        return "success";
    }
}
