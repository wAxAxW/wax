package com.example.demo.aop;

import com.example.demo.ListenerApplicationTests;
import com.example.demo.entity.UserTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @date
 */
public class AopTest extends ListenerApplicationTests {
    @Autowired
    UserTest userTest;

    @Test
    public void aopTest() {
        System.out.println(userTest);
        userTest.work();
    }


}
