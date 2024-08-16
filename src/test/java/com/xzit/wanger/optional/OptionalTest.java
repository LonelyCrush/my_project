package com.xzit.wanger.optional;

import com.xzit.practice.collection.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author leizefeng
 */
@SuppressWarnings("ConstantConditions")
@SpringBootTest
public class OptionalTest {

    private final Student student = null;

    @Test
    public void test1() {
        String name = student == null? null : student.getName();
        System.out.println(name);
    }

    @Test
    public void test2() {
        String name = Optional.ofNullable(student).map(Student::getName).orElse(null);
        System.out.println(name);
    }

    @Test
    public void test3() {
        Optional.ofNullable(student).ifPresent(student -> System.out.println(student.getName()));
    }
}
