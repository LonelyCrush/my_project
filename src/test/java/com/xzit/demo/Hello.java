package com.xzit.demo;


import com.xzit.practice.collection.Student;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * @author leizefeng
 */
public class Hello {

    public void doSomething() {
        String[] strings = {null, "Hello", ""};
        for (String string : strings) {
            System.out.println(StringUtils.hasText(string));
        }

        List<Object> list1 = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list1));

        List<Object> list2 = null;
        System.out.println(CollectionUtils.isEmpty(list2));

        System.out.println(Objects.requireNonNull(list1));
        Objects.requireNonNull(list2);
    }

    private static String handleName(String originalName) {
        // check
        if (org.apache.commons.lang3.StringUtils.isEmpty(originalName)) {
            return originalName;
        }

        // handle
        String[] names = originalName.split(" ");
        StringBuilder desensitizedName = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                desensitizedName.append(names[i]).append(" ");
            } else {
                desensitizedName.append(names[i].charAt(0)).append("** ");
            }
        }

        return desensitizedName.toString().trim();
    }

    private static String handleStringLength(String originalString, int maxLength) {
        if (originalString == null || originalString.length() >= maxLength) {
            return originalString;
        } else {
            originalString += " ";
            return handleStringLength(originalString, maxLength);
        }
    }

    private static String removeLeftZeros(String originalString) {
        if (originalString == null || "".equals(originalString.trim()) || originalString.charAt(0) != '0') {
            return originalString;
        } else {
            return removeLeftZeros(originalString.substring(1));
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice1", 20);
        Student student2 = new Student("Alice2", 20);
        Student student3 = new Student("Alice3", 20);
        List<Student> list = new ArrayList<>();
        Collections.addAll(list, student1, student2, student3);
    }
}
