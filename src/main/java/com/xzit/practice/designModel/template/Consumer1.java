package com.xzit.practice.designModel.template;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:32
 */
public class Consumer1 extends RestaurantTemplate {

    @Override
    void order() {
        System.out.print("  点了啤酒小吃");
    }

    @Override
    void pay() {
        System.out.print("  付了50元");
    }
}
