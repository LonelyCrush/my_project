package com.xzit.module.desensitization_fastjson.controller;

import com.xzit.module.desensitization_annotation_custom.pojo.TestPojo;
import com.xzit.module.desensitization_fastjson.pojo.TestPojo2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastjson")
public class TestController2 {

    @RequestMapping("/test")
    public TestPojo2 testDesensitization() {
        return new TestPojo2("frank", "13812345678", "123456", "Mars a road");
    }
}
