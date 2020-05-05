package com.example.demo.listener;

import com.example.demo.event.YouTestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
@Async
public class YourTestListener implements ApplicationListener<YouTestEvent> {

    @Override
    public void onApplicationEvent(YouTestEvent youTestEvent) {
        System.out.println(youTestEvent + "你的测试事件");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你的测试时间已完成");
    }
}
