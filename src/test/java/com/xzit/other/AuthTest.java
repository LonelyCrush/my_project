package com.xzit.other;

import com.alibaba.fastjson.JSON;
import com.xzit.practice.tree.domain.Auth;
import com.xzit.practice.tree.domain.ProductType;
import com.xzit.practice.tree.service.AuthService;
import com.xzit.practice.tree.service.ProductTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 17:11
 */
@SpringBootTest
public class AuthTest {

    @Resource
    private AuthService authService;

    @Test
    void test0() {
        List<Auth> list = authService.getAuthTree();
        System.out.println(JSON.toJSONString(list));
    }
}
