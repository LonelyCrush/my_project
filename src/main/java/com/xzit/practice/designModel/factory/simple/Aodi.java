package com.xzit.practice.designModel.factory.simple;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:24
 */
public class Aodi implements Car {

    @Override
    public void run() {
        System.out.println("奥迪汽车启动");
    }
}
