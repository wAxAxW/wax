package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author
 * @date
 */
public class MyTestEvent extends ApplicationEvent {
    private static final long serialVersionUID = 3525987073403122343L;

    public MyTestEvent(Object source) {
        super(source);
    }
}
