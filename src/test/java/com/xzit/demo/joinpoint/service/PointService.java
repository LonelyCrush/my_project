package com.xzit.demo.joinpoint.service;

import org.springframework.stereotype.Service;

/**
 * @author leizefeng
 */
@Service
public class PointService {

    public void sayHello(String str1, String str2) {
        System.out.println("Hello World![" + str1 + "];[" + str2 + "]");
    }
}
