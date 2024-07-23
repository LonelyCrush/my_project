package com.xzit.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author FH11702
 */
public class AboutStream {

    public static void main(String[] args) {
        testToMap();
    }

    private static void testToMap() {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("a", 13);
        Student student2 = new Student("b", 12);
        Student student3 = new Student(null, 11);
        Student student4 = new Student(null, 14);
        Student student7 = new Student(null, null);
        Student student5 = new Student("d", null);
        Student student6 = new Student("d", 17);

        Collections.addAll(list, student1, student2, student3, student4, student5, student6, student7);

        // key不能重复
        // value不能为空
        Map<String, Integer> map = list.stream()
                .filter(s -> s.getName() != null || s.getAge() != null)
                .collect(Collectors.toMap(Student::getName, s -> s.getAge() == null ? -1 : s.getAge(), (v1, v2) -> v2));

        System.out.println(map);
    }
}
