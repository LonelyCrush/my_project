package com.xzit.module.junit_mockito.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OneControllerTest {

    @Resource
    private WebApplicationContext webApplicationContext;

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testGetPriceByProductCode() throws Exception {
        // 执行请求（使用GET请求，restful接口）
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/one/{productCode}", "aaa")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        // 获取返回结果
        MockHttpServletResponse response = mvcResult.getResponse();

        // 获取返回编码
        int status = response.getStatus();

        // 获取返回内容
        String content = response.getContentAsString();
        System.out.println(content);

        // 断言状态码
        Assertions.assertEquals(200, status);
        Assertions.assertInstanceOf(String.class, content);
    }
}
