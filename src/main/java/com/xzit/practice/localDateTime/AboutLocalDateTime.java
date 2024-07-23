package com.xzit.practice.localDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AboutLocalDateTime {

    public static void main(String[] args) {
        testNow();
        testToString();
        testDaysOfThisYear();
    }

    private static void testNow() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);
    }

    private static void testToString() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(formattedDateTime);
        LocalDateTime parsedDateTime = LocalDateTime.parse("2022-12-24 15:30:45", formatter);
        System.out.println(parsedDateTime);
    }

    private static void testDaysOfThisYear() {
        int days = Year.now().length();
        System.out.println("今年的天数：" + days);

        System.out.println(Year.from(LocalDateTime.now()).length());
        System.out.println(Year.from(LocalDate.of(2011, 1, 1)).length());
    }

    private static void testCalendar() {
        System.out.println(Calendar.JANUARY);
    }
}
