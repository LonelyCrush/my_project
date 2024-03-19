package com.xzit;

import com.xzit.demo.HelloDemo;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyProjectApplicationTests {

    @Test
    void contextLoads() {
        HelloDemo.hello();
        String s = "https:/ /www.hotjob.cn/ wt/TZBANK/web/index/ca";
        System.out.println(s.replace(" ", ""));
    }

}
