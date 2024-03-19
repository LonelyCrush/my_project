package com.xzit.practice.designModel.proxy.dynamic_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * 该类用于：jdk动态代理没有实现类的接口
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 15:21
 */
public class MyRoleInvocationHandler<T> implements InvocationHandler {

    private Class<T> target;

    public MyRoleInvocationHandler(Class<T> target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("add")) {
            System.out.println("事务开启");
            System.out.println("add方法实现");
            System.out.println("事务关闭");
        }
        return null;
    }

    public T getProxy() {
        ClassLoader classLoader = target.getClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{target}, this);
    }
}
