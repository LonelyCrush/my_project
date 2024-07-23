package com.xzit.practice.songshan;

public class AboutInit {

    public static void main(String[] args) {
        new X();
    }

    private static class X extends Y {
        static int c = 3;
        int d = 4;

        static {
            System.out.println("static block of X class");
        }

        {
            System.out.println("X initializer block");
        }

        X() {
            System.out.println("X constructor");
        }
    }

    private static class Y {
        static int a = 1;
        int b = 2;

        static {
            System.out.println("static block of Y class");
        }

        {
            System.out.println("Y initializer block");
        }

        Y() {
            System.out.println("Y constructor");
        }
    }
}
