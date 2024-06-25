package com.xzit.module.mock_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-20 21:35
 */
@RestController
@RequestMapping("/mockTest")
public class MockTestController {

    @GetMapping("/test")
    public String getName() {
        return "My name is frank.";
    }
}
