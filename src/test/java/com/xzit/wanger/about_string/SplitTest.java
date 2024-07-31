package com.xzit.wanger.about_string;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class SplitTest {

    @Test
    public void testSplit() {
        String str = "沉默王二.一枚有趣的程序员";
        String [] parts = str.split("\\.");
        System.out.println("第一部分：" + parts[0] +" 第二部分：" + parts[1]);
    }

    private static final Pattern twoPart = Pattern.compile("(.+)\\.(.+)");

    @Test
    public void TestPatternMatch() {
        checkString("沉默王二.一枚有趣的程序员");
        checkString("沉默王二.");
        checkString(".一枚有趣的程序员");
    }

    private static void checkString(String str) {
        Matcher m = twoPart.matcher(str);
        if (m.matches()) {
            System.out.println("第一部分：" + m.group(1) + " 第二部分：" + m.group(2));
        } else {
            System.out.println("不匹配");
        }
    }
}
