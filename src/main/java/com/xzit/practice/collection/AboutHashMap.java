package com.xzit.practice.collection;

import java.util.*;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-07-06 22:54
 */
public class AboutHashMap {

    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        map.put("a", new Student("a", 13));
        map.put("c", new Student("c", 11));
        map.put("b", new Student("b", 12));
        map.put("d", new Student("d", 10));
        map.put("e", new Student("e", 14));
        System.out.println(map);
        System.out.println("--------------------------------");

        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList, Comparator.reverseOrder());
        for (String s : keyList) {
            System.out.println(s + "-->" + map.get(s));
        }
        System.out.println("--------------------------------");

        Set<Map.Entry<String, Student>> entrySet = map.entrySet();
        List<Map.Entry<String, Student>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList, Comparator.comparing(o -> o.getValue().getAge()));
        for (Map.Entry<String, Student> item : entryList) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");
    }
}
