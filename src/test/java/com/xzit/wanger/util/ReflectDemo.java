package com.xzit.wanger.util;

/**
 * @author leizefeng
 */
public class ReflectDemo {

    private int id;
    private String name;

    public ReflectDemo() {
        System.out.println("构造方法");
    }

    private void print1() {
        System.out.println("我是沉默王二（私有方法）");
    }

    public void print2() {
        System.out.println("我是沉默王二（公共方法）");
    }
}
