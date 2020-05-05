package com.example.demo.listener;

import com.example.demo.event.SendEmailEvent;
import com.example.demo.event.SendMessageEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author
 * @date
 */
@Async
public class RegisterListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //我们定义了两个事件：发短信，发邮箱，他们一旦被发布都会被此方法调用
        //于是我们需要判断当前event的具体类型
        //如果是发邮箱事件
        if (event instanceof SendEmailEvent) {
            //模拟发送邮件事件
            System.out.println("正在向" + ((SendEmailEvent) event).getEmailAddress() + "发送邮件......");
            try {
                //模拟请求邮箱服务器、验证账号密码，发送邮件耗时。
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("邮件发送成功！");
            //是发短信事件
        } else if (event instanceof SendMessageEvent) {
            event = (SendMessageEvent) event;
            System.out.println("正在向" + ((SendMessageEvent) event).getPhoneNum() + "发送短信......");//模拟发送邮短信事件
            try {
                //模拟发送短信过程
                Thread.sleep(1 * 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("短信发送成功！");
        }
    }
}
