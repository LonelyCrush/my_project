package com.xzit;

import com.xzit.demo.HelloDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyProjectApplicationTests {

    @Test
    void contextLoads() {
        HelloDemo.hello();
    }

}
