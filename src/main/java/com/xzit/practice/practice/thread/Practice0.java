package com.xzit.practice.practice.thread;

import java.util.ArrayList;

/**
 * <p>
 * 该类用于：让两个线程交替打印A1B2C3
 * </p>
 *
 * @author leizf
 * @since 2024-04-18 17:33
 */
public class Practice0 {

    private static final Object LOCK = new Object();
    private static final String STRING_1 = "ABCDEFG";
    private static final String STRING_2 = "1234567";

    private static void print(String s) {
        for (int i = 0; i < s.length(); i++) {
            synchronized (LOCK) {
                System.out.print(s.charAt(i));
                LOCK.notifyAll();
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            print(STRING_1);
        }).start();
        new Thread(() -> {
            print(STRING_2);
        }).start();
    }

}
