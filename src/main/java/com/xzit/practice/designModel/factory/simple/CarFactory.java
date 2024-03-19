package com.xzit.practice.designModel.factory.simple;

/**
 * <p>
 * 该类用于：简单工厂
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:25
 */
public class CarFactory {

    public static Car createCar(String carName) {
        if ("宝马".equals(carName)) {
            return new Baoma();
        }
        if ("奥迪".equals(carName)) {
            return new Aodi();
        }
        return null;
    }
}
