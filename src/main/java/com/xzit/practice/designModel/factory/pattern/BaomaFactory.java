package com.xzit.practice.designModel.factory.pattern;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:33
 */
public class BaomaFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Baoma();
    }
}
