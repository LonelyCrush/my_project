package com.xzit.practice.reflection;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReflectionTravelObjectTest {

    @Test
    public void testHandlePersonNull() throws Exception {
        Class<ReflectionTravelObject> outerClass = ReflectionTravelObject.class;
        ReflectionTravelObject outerInstance = outerClass.getDeclaredConstructor().newInstance();

        Class<?> innerClass = outerClass.getDeclaredClasses()[0];
        Constructor<?> innerClassConstructor = innerClass.getDeclaredConstructor(String.class, Integer.class, String.class);
        innerClassConstructor.setAccessible(true);
        Object innerInstance = innerClassConstructor.newInstance("Tom", null, null);

        Method testMethod = outerClass.getDeclaredMethod("handlePersonNull", innerClass);
        testMethod.setAccessible(true);
        testMethod.invoke(outerInstance, innerInstance);
        System.out.println(innerInstance);

        Field ageField = innerClass.getDeclaredField("age");
        ageField.setAccessible(true);
        Field addressField = innerClass.getDeclaredField("address");
        addressField.setAccessible(true);
        Assertions.assertEquals(0, ageField.get(innerInstance));
        Assertions.assertEquals("Unknown", addressField.get(innerInstance));
    }
}
