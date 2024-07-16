package com.xzit.module.filter_interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-20 15:18
 */
@RestController
@RequestMapping("/filterInterceptor")
public class FilterInterceptorTestController {

    @GetMapping("/test1")
    public String test1() {
        System.out.println("控制器-业务处理");
        return "成功！";
    }
}
