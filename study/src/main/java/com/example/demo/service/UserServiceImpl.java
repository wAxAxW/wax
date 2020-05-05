package com.example.demo.service;

import com.example.demo.event.MyTestEvent;
import com.example.demo.event.SendEmailEvent;
import com.example.demo.event.SendMessageEvent;
import com.example.demo.event.YouTestEvent;
import com.example.demo.eventPublish.UserEventPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserEventPublish userEventPublish;

    @Override
    public void dologin() throws InterruptedException {
        //模拟用户注册的相关业务逻辑处理
        Thread.sleep(200);
        System.out.println("注册成功！");
        //下列向用户发送邮件
        //定义事件
        SendEmailEvent sendEmailEvent = new SendEmailEvent(this, "邮件");
        SendMessageEvent sendMessageEvent = new SendMessageEvent(this, "短信");
        //发布事件
        userEventPublish.publish(sendEmailEvent, sendMessageEvent);
    }

    @Override
    public void dologin1() throws InterruptedException {
        //模拟用户注册的相关业务逻辑处理
        Thread.sleep(200);
        System.out.println("注册成功！");
        //下列向用户发送邮件
        //定义事件
        MyTestEvent sendEmailEvent = new MyTestEvent(this);
        YouTestEvent sendMessageEvent = new YouTestEvent(this);
        //定义事件
        SendEmailEvent sendEmailEvent1 = new SendEmailEvent(this, "邮件");
        SendMessageEvent sendMessageEvent2 = new SendMessageEvent(this, "短信");
        //发布事件
        userEventPublish.publish(sendEmailEvent, sendMessageEvent, sendEmailEvent1, sendMessageEvent2);
        //userEventPublish.publish(sendMessageEvent);
    }

}
