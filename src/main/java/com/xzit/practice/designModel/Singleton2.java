package com.xzit.practice.designModel;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-16 11:09
 */
public class Singleton2 {

    private Singleton2() {
        System.out.println("Singleton2私有无参构造器");
    }

    // 静态内部类
    private static class Singleton2Instance {
        private static final Singleton2 SINGLETON = new Singleton2();
    }

    public static Singleton2 getSingleton2Instance() {
        return Singleton2Instance.SINGLETON;
    }

    public static void main(String[] args) {
        Singleton2 s1 = getSingleton2Instance();
        Singleton2 s2 = getSingleton2Instance();
        System.out.println(s1 == s2);
    }
}
