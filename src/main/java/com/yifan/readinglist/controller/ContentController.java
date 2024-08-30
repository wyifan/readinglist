package com.yifan.readinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * package_name: com.yifan.readinglist.controller
 * author: wyifa
 * date: 2024/8/30
 * description:
 */
@Controller
public class ContentController {
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}

