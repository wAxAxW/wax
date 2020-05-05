package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * 短信发送事件源
 *
 * @author
 * @date
 */
public class SendMessageEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5564144895675157157L;
    private String phoneNum;

    public SendMessageEvent(Object source, String phoneNum) {
        super(source);
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public SendMessageEvent setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }
}
