package com.xzit.practice.designModel.singleton;

/**
 * <p>
 * 该类用于：静态枚举类 单例
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 20:32
 */
public class Singleton3 {

    private static enum Singleton3Instance {
        SINGLETON;

        private Singleton3 singleton3;

        private Singleton3Instance() {
            System.out.println("静态枚举类的私有无参构造器！");
            singleton3 = new Singleton3();
        }

        public Singleton3 getSingleton3Instance() {
            return singleton3;
        }
    }

    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3Instance.SINGLETON.getSingleton3Instance();
        Singleton3 instance2 = Singleton3Instance.SINGLETON.getSingleton3Instance();
        System.out.println(instance1 == instance2);
    }
}
