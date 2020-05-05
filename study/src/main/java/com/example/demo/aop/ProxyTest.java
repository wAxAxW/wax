package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author
 * @date
 */
@Aspect
public class ProxyTest {

    @Pointcut("@annotation(com.example.demo.annotation.MyBeforeA)")
    public void test() {

    }

    @Before("test()")
    public void before(JoinPoint joinPoint) {
        System.out.println("调用之前");
    }

}
