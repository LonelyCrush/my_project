package com.xzit.wanger.about_string;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InternTest {

    @Test
    public void testIntern() {
        testInternTrue();
        testInternFalse();
    }

    /**
     * 第一行代码，字符串常量池中会先创建一个“二哥三妹”的对象，然后堆中会再创建一个“二哥三妹”的对象，s1 引用的是堆中的对象。
     *
     * 第二行代码，对 s1 执行 intern() 方法，该方法会从字符串常量池中查找“二哥三妹”这个字符串是否存在，此时是存在的，所以 s2 引用的是字符串常量池中的对象。
     *
     * 也就意味着 s1 和 s2 的引用地址是不同的，一个来自堆，一个来自字符串常量池，所以输出的结果为 false。
     */
    private void testInternFalse() {
        String s1 = new String("二哥三妹");
        String s2 = s1.intern();
        System.out.println(s1 == s2);
    }

    /**
     * 第一行代码，会在字符串常量池中创建两个对象，一个是“二哥”，一个是“三妹”，
     * 然后在堆中会创建两个匿名对象“二哥”和“三妹”，最后还有一个“二哥三妹”的对象（稍后会解释），s1 引用的是堆中“二哥三妹”这个对象。
     *
     * 第二行代码，对 s1 执行 intern() 方法，该方法会从字符串常量池中查找“二哥三妹”这个对象是否存在，此时不存在的，但堆中已经存在了，
     *
     * 所以字符串常量池中保存的是堆中这个“二哥三妹”对象的引用，也就是说，s2 和 s1的引用地址是相同的，所以输出的结果为 true。
     *
     * 也就是说，当编译器遇到 + 号这个操作符的时候，会将 new String("二哥") + new String("三妹") 这行代码编译为以下代码：
     *
     * new StringBuilder().append("二哥").append("三妹").toString();
     */
    private void testInternTrue() {
        String s1 = new String("二哥") + new String("三妹");
        String s2 = s1.intern();
        System.out.println(s1 == s2);
    }
}
