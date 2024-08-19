package com.xzit.myself.d240816;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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
    private static final String json2 = "[{\"name\":\"frank\",\"age\":12,\"birthDate\":\"2024-08-16 10:55:21.744\",\"amount\":\"123.212\"}" +
            ",{\"name\":\"frank2\",\"age\":13,\"birthDate\":\"2024-08-16 10:55:21.744\",\"amount\":\"123.288\"}]";

    public static void main(String[] args) throws JsonProcessingException {
//        test0();
//        test1();
        test2();
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

        List<Student> list = objectMapper.readValue(json2, new TypeReference<List<Student>>() {
        });
        BigDecimal amount1 = list.get(0).getAmount();
        BigDecimal amount2 = list.get(1).getAmount();
        System.out.println(amount1.subtract(amount2));
    }

    private static void test2() throws JsonProcessingException {
        new Student("foo", 17, LocalDateTime.now(), new BigDecimal("123"));
        new Student("fool", 19, LocalDateTime.now(), new BigDecimal("153"));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "foo");
        map1.put("age", 17);
        map1.put("birthDate", LocalDateTime.now());
        map1.put("amount", new BigDecimal("123"));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "fool");
        map2.put("age", 19);
        map2.put("birthDate", LocalDateTime.of(2024, 8, 18, 20, 30));
        map2.put("amount", new BigDecimal("153"));

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        System.out.println(list);
        System.out.println(list.getClass());

        List<Student> studentList = BeanUtil.copyToList(list, Student.class);
        System.out.println(studentList);

        studentList.sort(Comparator.comparing(Student::getBirthDate));
        System.out.println(studentList);
    }
}
