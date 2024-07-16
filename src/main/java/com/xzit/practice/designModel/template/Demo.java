package com.xzit.practice.designModel.template;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:33
 */
public class Demo {

    public static void main(String[] args) {
        RestaurantTemplate consumer0 = new Consumer0();
        RestaurantTemplate consumer1 = new Consumer1();
        consumer0.consume();
        System.out.println("--------------------------------");
        consumer1.consume();
    }
}
