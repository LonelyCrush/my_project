package com.xzit.practice.designModel.strategy;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:40
 */
public class Demo {

    public static void main(String[] args) {
        Context context1 = new Context(new WeChatStrategy());
        Context context2 = new Context(new ZhifubaoStrategy());
        Context context3 = new Context(new UlinkStrategy());
        context1.pay();
        context2.pay();
        context3.pay();
    }
}
