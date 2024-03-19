package com.xzit.practice.designModel.factory.pattern;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:33
 */
public class Demo {

    public static void main(String[] args) {
        Car car1 = new AodiFactory().createCar();
        car1.run();
        Car car2 = new BaomaFactory().createCar();
        car2.run();
    }
}
