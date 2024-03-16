package com.xzit.practice.designModel;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-16 10:45
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("私有无参构造器");
    }

    public static Singleton getSingletonInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton s1 = getSingletonInstance();
        Singleton s2 = getSingletonInstance();
        System.out.println(s1 == s2);
    }
}
