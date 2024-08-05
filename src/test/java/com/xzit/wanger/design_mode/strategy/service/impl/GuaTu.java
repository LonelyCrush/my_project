package com.xzit.wanger.design_mode.strategy.service.impl;

import com.xzit.wanger.design_mode.strategy.service.Coach;
import org.springframework.stereotype.Service;

/**
 * 德普·瓜迪奥拉
 */
@Service
public class GuaTu implements Coach {

    @Override
    public void defend() {
        System.out.println("进攻就是最好的防守");
    }
}
