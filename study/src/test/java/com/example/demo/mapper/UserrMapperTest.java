package com.example.demo.mapper;

import com.example.demo.ListenerApplicationTests;
import com.example.demo.config.GenerateBean;
import com.example.demo.config.GeneratePropertiesBean;
import com.example.demo.config.generate.GenerateCode;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * @author
 * @date
 */

public class UserrMapperTest extends ListenerApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GenerateBean generator;


    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testSelect1() {
        System.out.println(generator);
        Properties properties = generator.getProperties();
        //PropertySources appliedPropertySources = properties;
        System.out.println(properties);
    }

    @Autowired
    GeneratePropertiesBean generatePropertiesBean;
    @Autowired
    GenerateCode generateCode;

    @Test
    void testSelect2() {
        generateCode.generate();
    }
}
