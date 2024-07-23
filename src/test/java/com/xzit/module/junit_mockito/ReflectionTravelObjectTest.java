package com.xzit.module.junit_mockito;

import com.xzit.practice.reflection.ReflectionTravelObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 私有方法且入参是内部类的单元测试
 * @author: leizefeng
 * @date: 2024/7/22
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReflectionTravelObjectTest {

    @Test
    public void testHandlePersonNull() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 获取外部类
        Class<ReflectionTravelObject> reflectionTravelObjectClass = ReflectionTravelObject.class;
        // 获取外部类实例
        ReflectionTravelObject reflectionTravelObject = reflectionTravelObjectClass.getDeclaredConstructor().newInstance();
        // 获取内部类
        Class<?> innerPersonClass = reflectionTravelObjectClass.getDeclaredClasses()[0];
        // 获取内部类私有构造器，并允许操作
        Constructor<?> innerPersonClassDeclaredConstructor = innerPersonClass.getDeclaredConstructor(String.class, Integer.class, String.class);
        innerPersonClassDeclaredConstructor.setAccessible(true);
        // 获取内部类对象
        Object person = innerPersonClassDeclaredConstructor.newInstance("Tom", null, null);
        System.out.println(person);

        // 获取外部类方法，即测试方法，并允许操作
        Method handlePersonNullMethod = reflectionTravelObjectClass.getDeclaredMethod("handlePersonNull", innerPersonClass);
        handlePersonNullMethod.setAccessible(true);
        // 执行方法
        handlePersonNullMethod.invoke(reflectionTravelObject, person);
        System.out.println(person);

        // 获取内部类属性，并允许操作
        Field ageField = innerPersonClass.getDeclaredField("age");
        ageField.setAccessible(true);
        Field addressField = innerPersonClass.getDeclaredField("address");
        addressField.setAccessible(true);
        // 断言
        Assertions.assertEquals(0, ageField.get(person));
        Assertions.assertEquals("Unknown", addressField.get(person));
    }
}
