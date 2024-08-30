package com.yifan.readinglist.controller;

import com.yifan.readinglist.entity.ReadingUser;
import com.yifan.readinglist.repository.ReadingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package_name: com.yifan.readinglist.controller
 * author: wyifa
 * date: 2024/8/30 10:22
 * description:
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final ReadingUserRepository readingUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(ReadingUserRepository readingUserRepository, PasswordEncoder passwordEncoder) {
        this.readingUserRepository = readingUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user")
    public ReadingUser createUser(@RequestBody ReadingUser readingUser) {
        readingUser.setPassword(passwordEncoder.encode(readingUser.getPassword()));
        return readingUserRepository.save(readingUser);
    }
}
