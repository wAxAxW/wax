package com.example.demo.eventPublish;

import com.example.demo.event.MyTestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class EventHandle {
    @EventListener
    private void tst(MyTestEvent myTestEvent) {
        System.out.println("测试@EventListener注解");
    }
}
