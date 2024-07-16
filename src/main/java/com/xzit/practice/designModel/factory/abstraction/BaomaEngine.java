package com.xzit.practice.designModel.factory.abstraction;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-18 22:42
 */
class BaomaEngine implements Engine {

    @Override
    public void run() {
        System.out.println("宝马引擎启动");
    }
}
