package com.xzit.demo.rabbit_mq.work_mode.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.xzit.demo.rabbit_mq.work_mode.role.WorkSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Resource
    private WorkSender workSender;

    @GetMapping("/test")
    public String testWorkMode() {
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return "success";
    }
}
