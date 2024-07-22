package com.xzit.module.junit_mockito.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class TwoService {

    @Resource
    private OneService oneService;

    /**
     * 调用OneService中的getPriceByProduct方法
     * @param productCode code
     * @return price
     */
    public int getPriceByOneService(String productCode) {
        return oneService.getPriceByProductCode(productCode) + 1000;
    }

    /**
     * 调用TwoService中的getRandomPrice方法
     * @param productCode code
     * @return price
     */
    public int getPriceByTwoService(String productCode) {
        return oneService.getPriceByProductCode(productCode) + getRandomPrice(productCode) + 1000;
    }

    /**
     * 随机一个price
     * @param productCode dode
     * @return price
     */
    public int getRandomPrice(String productCode) {
        System.out.println("TwoService productCode：" + productCode);
        return new Random().nextInt(1000);
    }
}
