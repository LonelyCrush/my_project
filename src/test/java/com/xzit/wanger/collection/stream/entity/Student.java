package com.xzit.wanger.collection.stream.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author leizefeng
 */
@Data
@Accessors(chain = true)
public class Student {

    private String name;
    private int age;
}
