package com.xzit.practice.designModel.template;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:32
 */
public class Consumer0 extends RestaurantTemplate {

    @Override
    void order() {
        System.out.print("  点了茄子炒肉");
    }

    @Override
    void pay() {
        System.out.print("  付了20元");
    }
}
