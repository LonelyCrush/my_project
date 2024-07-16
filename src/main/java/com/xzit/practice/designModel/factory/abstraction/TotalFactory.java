package com.xzit.practice.designModel.factory.abstraction;

/**
 * <p>
 * 该类用于：抽象工厂
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:43
 */
public interface TotalFactory {

    Car createCar();

    Engine createEngine();
}
