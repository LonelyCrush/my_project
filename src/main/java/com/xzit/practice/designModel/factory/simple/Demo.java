package com.xzit.practice.designModel.factory.simple;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:28
 */
public class Demo {

    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("奥迪");
        car1.run();
        Car car2 = CarFactory.createCar("宝马");
        car2.run();
    }
}
