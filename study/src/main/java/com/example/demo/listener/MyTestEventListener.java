package com.example.demo.listener;

import com.example.demo.event.MyTestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
@Async
public class MyTestEventListener implements ApplicationListener<MyTestEvent> {
    @Override
    public void onApplicationEvent(MyTestEvent myTestEvent) {
        System.out.println(myTestEvent + "自己的测试事件");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("自己的测试时间已完成");
    }
}
