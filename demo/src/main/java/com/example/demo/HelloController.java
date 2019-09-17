package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/9/17 9:32 上午
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
