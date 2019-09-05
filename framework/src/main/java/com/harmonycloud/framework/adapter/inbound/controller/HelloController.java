package com.harmonycloud.framework.adapter.inbound.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019-09-05 10:50
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }
}
