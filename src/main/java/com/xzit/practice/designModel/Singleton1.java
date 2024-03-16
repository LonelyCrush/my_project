package com.xzit.practice.designModel;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-16 11:04
 */
public class Singleton1 {

    private Singleton1() {
        System.out.println("Singleton1私有无参构造器");
    }

    // 懒汉
    private static Singleton1 singleton;

    public synchronized static Singleton1 getSingletonInstance() {
        if (singleton == null) singleton = new Singleton1();
        return singleton;
    }

    public static void main(String[] args) {
        Singleton1 s1 = getSingletonInstance();
        Singleton1 s2 = getSingletonInstance();
        System.out.println(s1 == s2);
    }
}
