package com.xzit.practice.designModel.strategy;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:38
 */
public class ZhifubaoStrategy extends PayStrategy {

    @Override
    void payManner() {
        System.out.println("使用支付宝支付");
    }
}
