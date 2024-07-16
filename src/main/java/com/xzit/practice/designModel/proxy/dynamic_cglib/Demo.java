package com.xzit.practice.designModel.proxy.dynamic_cglib;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:17
 */
public class Demo {

    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        UserDaoImpl proxy = (UserDaoImpl) myMethodInterceptor.getInstance(userDaoImpl);
        proxy.add();
    }
}
