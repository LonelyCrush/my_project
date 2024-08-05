package com.xzit.demo.joinpoint.test;

import com.xzit.demo.joinpoint.service.PointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author leizefeng
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PointServiceTest {

    @Resource
    private PointService pointService;

    @Test
    public void testPointService() {
        pointService.sayHello("aaaa", "bbbb");
    }
}
