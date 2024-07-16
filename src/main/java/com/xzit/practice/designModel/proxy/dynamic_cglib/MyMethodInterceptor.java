package com.xzit.practice.designModel.proxy.dynamic_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * 该类用于：cglib动态代理
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:10
 */
public class MyMethodInterceptor implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        // 子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开启");
        Object object = methodProxy.invoke(target, objects);
        System.out.println("事务关闭");
        return object;
    }
}
