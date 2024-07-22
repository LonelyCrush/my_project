package com.xzit.practice.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * @description: Traverse the properties and values of an object through reflections
 * @author: leizefeng
 * @date: 2024/7/22
 **/
public class ReflectionTravelObject {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = Person.getInstanceNotNull();
        Person person2 = Person.getInstanceWithNull();
        Person person3 = ((Person) person2.clone());
        person3.setAddress(null);

        handlePersonNull(person1);
        handlePersonNull(person2);
        handlePersonNull(person3);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }

    private static void handlePersonNull(Person person) {
        Field[] declaredFields = person.getClass().getDeclaredFields();
        for (Field item : declaredFields) {
            // todo:允许反射修改私有属性
            item.setAccessible(true);
            try {
                if (item.get(person) != null) {
                    continue;
                }
                if (item.getType() == String.class) {
                    item.set(person, "Unknown");
                } else if (item.getType() == Integer.class) {
                    item.set(person, 0);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person implements Cloneable {
        private String name;
        private Integer age;
        private String address;

        public static Person getInstanceNotNull() {
            return new Person("Tom", 20, "China");
        }

        public static Person getInstanceWithNull() {
            return new Person("Tom", null, "China");
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
