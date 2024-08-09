package com.xzit.demo;


import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author leizefeng
 */
public class Hello {

    public static void main(String[] args) {
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
}
