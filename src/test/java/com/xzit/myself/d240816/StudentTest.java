package com.xzit.myself.d240816;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-08-16 18:17
 */
public class StudentTest {

    private static final String json1 = "{\"name\":\"frank\",\"age\":12,\"birthDate\":\"2024-08-16 10:55:21.744\"}";
    private static final String json2 = "[{\"name\":\"frank\",\"age\":12,\"birthDate\":\"2024-08-16 10:55:21.744\"},{\"name\":\"frank2\",\"age\":13,\"birthDate\":\"2024-08-16 10:55:21.744\"}]";

    public static void main(String[] args) throws JsonProcessingException {
//        test0();
        test1();
    }

    private static void test0() throws JsonProcessingException {
//        Student student1 = new Student("frank", 12, new Date());
//        Student student2 = new Student("frank2", 13, new Date());
//        List<Student> list = new ArrayList<>();
//        list.add(student1);
//        list.add(student2);

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        String json1 = objectMapper.writeValueAsString(list);
//        System.out.println(json1);
    }

    private static void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        // 忽略未知字段
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        // 忽略字段大小写
//        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        // 处理时间类型
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

        Student student = objectMapper.readValue(json1, Student.class);
        System.out.println(student);
        System.out.println(objectMapper.writeValueAsString(student));
    }
}
