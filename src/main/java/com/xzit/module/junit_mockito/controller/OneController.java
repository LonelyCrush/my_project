package com.xzit.module.junit_mockito.controller;

import com.xzit.module.junit_mockito.service.TwoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/one")
public class OneController {

    @Resource
    private TwoService twoService;

    @GetMapping("/{productCode}")
    public String getPriceByProductCode(@PathVariable String productCode) {
        return String.valueOf(twoService.getPriceByTwoService(productCode));
    }
}
