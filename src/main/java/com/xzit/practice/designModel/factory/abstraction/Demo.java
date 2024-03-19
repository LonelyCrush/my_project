package com.xzit.practice.designModel.factory.abstraction;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:47
 */
public class Demo {

    public static void main(String[] args) {
        Car car = new AodiFactory().createCar();
        car.run();
        Engine engine = new AodiFactory().createEngine();
        engine.run();
    }
}
