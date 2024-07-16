package com.xzit.practice.designModel.factory.abstraction;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:44
 */
public class AodiFactory implements TotalFactory {

    @Override
    public Car createCar() {
        return new AodiCar();
    }

    @Override
    public Engine createEngine() {
        return new AodiEngine();
    }
}
