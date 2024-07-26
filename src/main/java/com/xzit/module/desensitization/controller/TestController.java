package com.xzit.module.desensitization.controller;

import com.xzit.module.desensitization.pojo.TestPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public TestPojo testDesensitization() {
        return new TestPojo("frank", "13812345678", "123456", "Mars");
    }
}
