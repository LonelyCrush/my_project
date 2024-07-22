package com.xzit.module.junit_mockito.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OneService {

    /**
     * 根据code查询price
     * @param productCode code
     * @return price
     */
    public int getPriceByProductCode(String productCode) {
        System.out.println("OneService productionCode: " + productCode);
        return new Random().nextInt(1000);
    }
}
