package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void dologin() throws InterruptedException {
        userService.dologin();
    }

    @Test
    void dologin1() throws InterruptedException {
        userService.dologin1();
    }
}