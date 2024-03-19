package com.xzit.practice.designModel.strategy;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:40
 */
public class Context {

    private PayStrategy payStrategy;

    public Context(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void pay() {
        payStrategy.payManner();
    }
}
