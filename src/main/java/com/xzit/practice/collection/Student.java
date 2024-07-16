package com.xzit.practice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-07-06 21:55
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Student {

    private String name;
    private Integer age;
}
