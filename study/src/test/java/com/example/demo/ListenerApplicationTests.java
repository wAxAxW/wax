package com.example.demo;

import com.example.demo.utils.SpaCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
@EnableAspectJAutoProxy
public
@Slf4j
class ListenerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void etka() {
        String etka = "N 90942902";
        log.info("德国备件号:\n{}", etka);
        String spa1 = SpaCodeUtils.toSpaCode(etka);
        
        String spa = SpaCodeUtils.toDSERP(etka);
        log.info("国产备件号:\n{}", spa);
        String temp = "N   909 429 02";
        log.info("是否成功", temp.equals("spa"));
    }
}
