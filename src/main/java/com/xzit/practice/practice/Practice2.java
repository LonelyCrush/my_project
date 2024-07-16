package com.xzit.practice.practice;

/**
 * <p>
 * 该类用于：语法糖的使用
 * </p>
 *
 * @author leizf
 * @since 2024-04-19 17:28
 */
public class Practice2 {

    public static void main(String[] args) {
        String[] strings = {"JavaGuide", "公众号：JavaGuide", "博客：https://javaguide.cn/"};
        int i = 0;

        for (String string : strings) {
            System.out.println(string);
            i++;
        }

        System.out.println(i);
    }
}
