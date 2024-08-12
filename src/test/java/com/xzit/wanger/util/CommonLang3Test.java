package com.xzit.wanger.util;

import com.google.common.collect.Lists;
import com.xzit.wanger.collection.stream.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * @author leizefeng
 */
@SuppressWarnings("ALL")
@SpringBootTest
public class CommonLang3Test {

    @Test
    public void testIsBlank() {
        // 注意 isEmpty() 和 isBlank() 的区别
        // isEmpty() 判定字符串是否为空串（null 或 空白字符）
        // isBlank() 判定字符串是否为空串（null 或 空白字符）或仅由空白字符组成
        System.out.println(StringUtils.isEmpty("")); // true
        System.out.println(StringUtils.isEmpty(" ")); // false
        System.out.println(StringUtils.isEmpty(null)); // true

        System.out.println(StringUtils.isBlank("")); // true
        System.out.println(StringUtils.isBlank(" ")); // true
        System.out.println(StringUtils.isBlank(null)); // true
    }

    @Test
    public void testSplit() {
        // 使用 StringUtils 的 split 方法会返回 null，而使用 String 的 split 方法会报指针异常
        String str1 = null;
        System.out.println(StringUtils.split(str1,","));
        System.out.println(str1.split(","));
    }

    @Test
    public void testIsNumeric() {
        // isNumeric() 方法会返回 true，如果字符串中所有字符都为数字，不含浮点数
        System.out.println(StringUtils.isNumeric("123")); // true
        System.out.println(StringUtils.isNumeric("12b")); // false
        System.out.println(StringUtils.isNumeric("0.33")); // false
        System.out.println(StringUtils.isNumeric("012.")); // false
        System.out.println(StringUtils.isNumeric("012")); // true
    }

    @Test
    public void testJoin() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        List<Integer> list2 = Lists.newArrayList(1, 2, 3);
        System.out.println(StringUtils.join(list, ","));
        System.out.println(StringUtils.join(list2, " "));
    }

    @Test
    public void testEquals() {

    }

    @Test
    public void testContains() {

    }

    @Test
    public void test0() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    @Test
    public void test1() {
        Student tom = new Student().setName("Tom").setAge(17);
        Student jack = new Student().setName("Jack").setAge(19);
        Student jerry = new Student().setName("Jerry").setAge(20);
        Student alice = new Student().setName("Alice").setAge(17);
        Student amo = new Student().setName("Amo").setAge(17);
        Student aka = new Student().setName("Aka").setAge(17);
        ArrayList<Student> studentList = Lists.newArrayList(tom, jack, jerry, alice, amo, aka); // 其实本质上调用Collections.addAll()
        Comparator<Student> comparator = Comparator.comparing(Student::getAge, Comparator.reverseOrder())
                .thenComparing(Student::getName);
        studentList.sort(comparator);
        Collections.sort(studentList, comparator); // 其实本质上调用了list.sort()
        System.out.println(studentList);
    }

    @Test
    public void test2() {
        Student tom = new Student().setName("西门吹雪").setAge(17);
        Student jack = new Student().setName("东方不败").setAge(19);
        Student jerry = new Student().setName("南宫问天").setAge(20);
        Student alice = new Student().setName("北方落尘").setAge(17);
        List<Student> studentList = Lists.newArrayList(tom, jack, jerry, alice);

        // 普通排序无法按照拼音排序
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println(studentList);

        // 需要自定义
        studentList.sort(new Comparator<Student>() {
            private Collator collator = Collator.getInstance(Locale.CHINA);

            @Override
            public int compare(Student o1, Student o2) {
                return collator.compare(o1.getName(), o2.getName());
            }
        });
        System.out.println(studentList);
    }

    /**
     * trim(String str)：去除字符串首尾的空白字符。
     * trimToEmpty(String str)：去除字符串首尾的空白字符，如果字符串为 null，则返回空字符串。
     * trimToNull(String str)：去除字符串首尾的空白字符，如果结果为空字符串，则返回 null。
     * equals(String str1, String str2)：比较两个字符串是否相等。
     * equalsIgnoreCase(String str1, String str2)：比较两个字符串是否相等，忽略大小写。
     * startsWith(String str, String prefix)：检查字符串是否以指定的前缀开头。
     * endsWith(String str, String suffix)：检查字符串是否以指定的后缀结尾。
     * contains(String str, CharSequence seq)：检查字符串是否包含指定的字符序列。
     * indexOf(String str, CharSequence seq)：返回指定字符序列在字符串中首次出现的索引，如果没有找到，则返回 -1。
     * lastIndexOf(String str, CharSequence seq)：返回指定字符序列在字符串中最后一次出现的索引，如果没有找到，则返回 -1。
     * substring(String str, int start, int end)：截取字符串中指定范围的子串。
     * replace(String str, String searchString, String replacement)：替换字符串中所有出现的搜索字符串为指定的替换字符串。
     * replaceAll(String str, String regex, String replacement)：使用正则表达式替换字符串中所有匹配的部分。
     * join(Iterable<?> iterable, String separator)：使用指定的分隔符将可迭代对象中的元素连接为一个字符串。
     * split(String str, String separator)：使用指定的分隔符将字符串分割为一个字符串数组。
     * capitalize(String str)：将字符串的第一个字符转换为大写。
     * uncapitalize(String str)：将字符串的第一个字符转换为小写。
     */
}
