package com.xzit.practice.practice;

/**
 * <p>
 * 该类用于：让三个线程交替打印A1aB2bC3c
 * </p>
 *
 * @author leizf
 * @since 2024-04-18 17:33
 */
public class Practice1 {

    private static int count = 0;
    private static final int THREAD_NUM = 3;
    private static final Object LOCK = new Object();
    private static final String STRING_1 = "ABCDEFG";
    private static final String STRING_2 = "1234567";
    private static final String STRING_3 = "abcdefg";

    private static void print(String s, int order) {
        for (int i = 0; i < s.length(); i++) {
            synchronized (LOCK) {
                while (count % THREAD_NUM != order) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.print(s.charAt(i));
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            print(STRING_1, 0);
        }).start();
        new Thread(() -> {
            print(STRING_2, 1);
        }).start();
        new Thread(() -> {
            print(STRING_3, 2);
        }).start();
    }

}
