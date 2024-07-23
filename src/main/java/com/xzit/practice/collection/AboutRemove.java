package com.xzit.practice.collection;

import java.util.ArrayList;
import java.util.List;

public class AboutRemove {

    public static void main(String[] args) {
        testRemove();
    }

    private static void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        list.removeIf("1"::equals);
        System.out.println(list);
    }
}
