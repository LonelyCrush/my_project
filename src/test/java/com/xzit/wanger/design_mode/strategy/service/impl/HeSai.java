package com.xzit.wanger.design_mode.strategy.service.impl;

import com.xzit.wanger.design_mode.strategy.service.Coach;
import org.springframework.stereotype.Service;

/**
 * 何塞·穆里尼奥
 */
@Service
public class HeSai implements Coach {

    @Override
    public void defend() {
        System.out.println("防守赢得冠军");
    }
}
