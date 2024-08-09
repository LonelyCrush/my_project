package com.xzit.wanger.collection.stream;

import com.xzit.wanger.collection.stream.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author leizefeng
 */
@SpringBootTest
public class StreamTest implements Comparator<Student> {

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

        Comparator<Student> comparator = Comparator
                .comparing(Student::getAge, Comparator.reverseOrder())
                .thenComparing(Student::getName);
        List<Student> list = students.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testStreamSorted1() {
        Student tom = new Student().setName("西门吹雪").setAge(17);
        Student jack = new Student().setName("东方不败").setAge(19);
        Student jerry = new Student().setName("南宫问天").setAge(20);
        Student alice = new Student().setName("北方落尘").setAge(17);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, tom, jack, jerry, alice);

        // 中文拼音排序
        List<Student> list = students.stream().sorted(new StreamTest()).collect(Collectors.toList());
        System.out.println(list);
    }

    private Collator collator = Collator.getInstance(Locale.CHINA);

    @Override
    public int compare(Student o1, Student o2) {
        return collator.compare(o1.getName(), o2.getName());
    }

    @Test
    public void testStreamFilter() {
        Student tom = new Student().setName("Tom").setAge(17);
        Student jack = new Student().setName("Jack").setAge(19);
        Student jerry = new Student().setName("Jerry").setAge(20);
        Student alice = new Student().setName("Alice").setAge(17);
        List<Student> students = new ArrayList<>();
        Collections.addAll(students, tom, jack, jerry, alice);

//        List<Student> list = students.stream().filter(student -> student.getAge() >= 18).collect(Collectors.toList());
        students = students.stream()
                .filter(student -> !student.getName().equals("Tom") && student.getAge() < 18)
                .collect(Collectors.toList());
        System.out.println(students);
    }
}
