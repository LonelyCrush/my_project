package com.xzit.practice.java8LocalDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class AboutOffsetDateTime {

    public static void main(String[] args) {
//        testNow();
//        testOf();
//        testFrom();
//        testParse();
        testIsSupported();
    }

    public static void testIsSupported() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2023, 11, 28, 23, 46, 56, 0, ZoneOffset.ofHours(8));
        boolean supported1 = offsetDateTime.isSupported(ChronoField.YEAR);
        boolean supported2 = offsetDateTime.isSupported(ChronoUnit.HOURS);
        System.out.println(supported1);//输出结果：true
        System.out.println(supported2);//输出结果：true
    }

    private static void testParse() {
        System.out.println(OffsetDateTime.parse("2023-11-27T09:45:56+08:00"));
        System.out.println("-----------------------------");
    }

    private static void testFrom() {
//        LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 27, 18, 42, 56);
//        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
//        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneOffset);
//        OffsetDateTime from = OffsetDateTime.from(zonedDateTime);
//        System.out.println(from);//2023-11-27T18:42:56+08:00

        System.out.println(OffsetDateTime.from(LocalDateTime.now().atZone(ZoneOffset.ofHours(8))));
        System.out.println("-----------------------------");

    }

    private static void testOf() {
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(8)));
        System.out.println("-----------------------------");

//        LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 27, 18, 42, 56);
//        // 北京属于东八区
//        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(8));
//        // 纽约属于西五区
//        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(-5));
//        System.out.println(offsetDateTime);
//        System.out.println(offsetDateTime1);
//        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(8)));
//        // 输出结果：2023-11-27T18:42:56+08:00
//        System.out.println("-----------------------------");
//
//        Duration between = Duration.between(offsetDateTime, offsetDateTime1);
//        long hours = between.toHours();
//        System.out.println(hours);
//        // 以美国纽约时间与中国北京时间相差13个小时，输出结果：13
//        System.out.println("-----------------------------");
//
//        Instant instant = Instant.ofEpochSecond(1L);
//        System.out.println(instant);
//        // 输出结果：1970-01-01T00:00:01Z
//        OffsetDateTime offsetDateTime2 = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());
//        System.out.println(offsetDateTime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        // 输出结果：1970-01-01 08:00:01,这与上面的输出结果相差了8个小时，
//        // 原因就在于ZoneId.systemDefault()获取了系统默认时区，中国采用东八区时区，因此与格林尼治时间相差了8小时
    }

    private static void testNow() {
        System.out.println(LocalDateTime.now());
        // 偏移量
        System.out.println(OffsetDateTime.now());
    }
}
