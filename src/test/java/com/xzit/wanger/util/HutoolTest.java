package com.xzit.wanger.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ReflectUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author leizefeng
 */
@SpringBootTest
public class HutoolTest {

    @Test
    public void testToInt() {
        // Hutool 的 Convert 类可以简化这个操作，可以将任意可能的类型转换为指定类型，同时第二个参数 defaultValue 可用于在转换失败时返回一个默认值。
        // 且无需判空
        // to int
        String param1 = "10";
        String param2 = "";
        System.out.println(Convert.toInt(param1));
        System.out.println(Convert.toInt(param2, 0));
        System.out.println(Convert.toInt(""));
        System.out.println(Convert.toInt(null));
    }

    @Test
    public void testToLocalDateTime() {
        // to localDateTime
        String dateStr1 = "2020年09月29日";
        String dateStr2 = "2020-09-29";
        String dateStr3 = "2020.09-29";
        String dateStr4 = "20200929";
        System.out.println(Convert.toLocalDateTime(dateStr1).toLocalDate());
        System.out.println(Convert.toLocalDateTime(dateStr2).toLocalDate());
        System.out.println(Convert.toLocalDateTime(dateStr3).toLocalDate());
        System.out.println(Convert.toLocalDateTime(dateStr4).toLocalDate());
    }

    @Test
    public void testToString() {
        // to String
        System.out.println(DateUtil.format(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void testDateUtil() {
        System.out.println(DateUtil.date());
    }

    @Test
    public void testReflectUtil() throws NoSuchMethodException {
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        Constructor<?>[] constructors = reflectDemoClass.getDeclaredConstructors();
        Field[] fields = reflectDemoClass.getDeclaredFields();
        Method[] methods = reflectDemoClass.getDeclaredMethods();
        System.out.println(Arrays.toString(constructors));
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(methods));

        System.out.println("-------------");
        Constructor<ReflectDemo>[] constructors1 = ReflectUtil.getConstructors(reflectDemoClass);
        Field[] fields1 = ReflectUtil.getFields(reflectDemoClass);
        Method[] methods1 = ReflectUtil.getMethods(reflectDemoClass);
        System.out.println(Arrays.toString(constructors1));
        System.out.println(Arrays.toString(fields1));
        System.out.println(Arrays.toString(methods1));
    }

    @Test
    public void testValidator() {
        System.out.println(Validator.isGeneral("沉默王二"));
        System.out.println(Validator.isEmail("itwanger@1.com"));
    }
}
