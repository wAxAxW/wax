package com.example.demo.eventPublish;

import com.example.demo.event.MyTestEvent;
import com.example.demo.event.YouTestEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class UserEventPublish implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 消息推送
     *
     * @param event
     */
    public void publish(ApplicationEvent... event) {
        for (ApplicationEvent applicationEvent : event) {
            this.applicationEventPublisher.publishEvent(applicationEvent);
        }
    }

    public void publish(MyTestEvent myTestEvent, YouTestEvent youTestEvent) {
        this.applicationEventPublisher.publishEvent(myTestEvent);
        this.applicationEventPublisher.publishEvent(youTestEvent);
    }
}
