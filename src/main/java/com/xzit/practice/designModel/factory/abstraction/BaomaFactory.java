package com.xzit.practice.designModel.factory.abstraction;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:46
 */
public class BaomaFactory implements TotalFactory {

    @Override
    public Car createCar() {
        return new BaomaCar();
    }

    @Override
    public Engine createEngine() {
        return new BaomaEngine();
    }
}
