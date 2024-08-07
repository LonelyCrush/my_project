package com.xzit.wanger.collection.stream;

import com.xzit.wanger.collection.stream.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leizefeng
 */
@SpringBootTest
public class TestStream {

    @Test
    public void testStreamSorted() {
        Student tom = new Student().setName("Tom").setAge(17);
        Student jack = new Student().setName("Jack").setAge(19);
        Student jerry = new Student().setName("Jerry").setAge(20);
        Student alice = new Student().setName("Alice").setAge(17);
        Student amo = new Student().setName("Amo").setAge(17);
        Student aka = new Student().setName("Aka").setAge(17);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, tom, jack, jerry, alice, amo, aka);

        Comparator<Student> comparator = Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getName);
        List<Student> list = students.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(list);
    }
}
