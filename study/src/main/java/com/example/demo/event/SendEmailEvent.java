package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * 邮件发送事件源
 *
 * @author
 * @date
 */
public class SendEmailEvent extends ApplicationEvent {
    private static final long serialVersionUID = -3422055737576555983L;
    private String emailAddress;

    public SendEmailEvent(Object source, String emailAddress) {
        super(source);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public SendEmailEvent setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
}
