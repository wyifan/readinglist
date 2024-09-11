package com.yifan.springboot_ioc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package_name: com.yifan.springboot_ioc.controller
 * author: wyifa
 * date: 2024/9/11 19:30
 * description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello ";
    }
}
