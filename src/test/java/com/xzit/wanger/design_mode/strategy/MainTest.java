package com.xzit.wanger.design_mode.strategy;

import com.xzit.wanger.design_mode.strategy.service.Coach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MainTest {

    @Resource
    private Coach heSai;
    @Resource
    private Coach guaTu;

    @Test
    public void main() {
        // 为同一个方法传递不同的对象
        heSai.defend();
        guaTu.defend();
    }
}
