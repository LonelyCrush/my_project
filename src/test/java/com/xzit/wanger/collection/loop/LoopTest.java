package com.xzit.wanger.collection.loop;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leizefeng
 */
@SpringBootTest public class LoopTest {

    @Test
    public void testForeach() {
        List<String> list = new ArrayList<>();
        list.add("沉默王二");
        list.add("沉默王三");
        list.add("一个文章真特么有趣的程序员");

        // 用该语法糖循环做删除会抛异常
        for (String str : list) {
            if ("沉默王二".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list);
    }
}
