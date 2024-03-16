package com.xzit.practice.designModel;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-16 10:45
 */
public class Singleton0 {

    private static Singleton0 singleton = new Singleton0();

    private Singleton0() {
        System.out.println("Singleton0私有无参构造器");
    }

    public static Singleton0 getSingletonInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton0 s1 = getSingletonInstance();
        Singleton0 s2 = getSingletonInstance();
        System.out.println(s1 == s2);
    }
}
