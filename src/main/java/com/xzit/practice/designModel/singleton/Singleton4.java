package com.xzit.practice.designModel.singleton;

/**
 * <p>
 * 该类用于：双重检测锁
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 20:42
 */
public class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4() {}

    public static Singleton4 getSingleton4Instance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }

        return singleton4;
    }

    public static void main(String[] args) {
        Singleton4 instance1 = Singleton4.getSingleton4Instance();
        Singleton4 instance2 = Singleton4.getSingleton4Instance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
