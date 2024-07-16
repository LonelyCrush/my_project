package com.xzit.practice.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-07-06 21:45
 */
public class AboutArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "2", "3", "4", "1", "5");
        Collections.sort(list); // 默认升序
        System.out.println(list);
        System.out.println("--------------------------------");

        List<Student> list1 = new ArrayList<>();
        Student student1 = new Student("a", 13);
        Student student2 = new Student("b", 12);
        Student student3 = new Student("c", 11);
        Collections.addAll(list1, student1, student2, student3);
        Collections.sort(list1, Comparator.comparing(Student::getName));
        System.out.println(list1);
        Collections.sort(list1, Comparator.comparing(Student::getAge));
        System.out.println(list1);
        System.out.println("--------------------------------");

        list1.sort(Comparator.comparing(Student::getName));
        System.out.println(list1);
        System.out.println("--------------------------------");

        Stream<Student> stream = list1.stream().sorted(Comparator.comparing(Student::getAge));
        List<Student> list2 = stream.collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("--------------------------------");
    }
}
