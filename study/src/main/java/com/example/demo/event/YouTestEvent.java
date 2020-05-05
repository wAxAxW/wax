package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author
 * @date
 */
public class YouTestEvent extends ApplicationEvent {
    private static final long serialVersionUID = -8727064478956502742L;

    public YouTestEvent(Object source) {
        super(source);
    }
}
