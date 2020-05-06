package com.smart.proxy.advice;

import com.smart.advice.*;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AdviceTest {
    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();

        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        AfterReturningAdvice afterReturningAdvice = new GreetingAfterAdvice();
        GreetingInterceptor greetingInterceptor = new GreetingInterceptor();


        ProxyFactory proxy = new ProxyFactory();
        proxy.setTarget(target);
        proxy.addAdvice(0,greetingInterceptor);
        proxy.addAdvice(1,beforeAdvice);
        proxy.addAdvice(2,afterReturningAdvice);

        proxy.setInterfaces(target.getClass().getInterfaces());//Interface proxy,use dynamic JDK proxy
        proxy.setOptimize(true);//use CGLib, ignore set interface

        Waiter proxyWaiter = (Waiter) proxy.getProxy();
        proxyWaiter.greetTo("Peter");
        proxyWaiter.service("Peter");

        //CGLIB to proxy class
        NaiveWaiter badWaiter = new NaiveWaiter();
        ProxyFactory badProxy = new ProxyFactory();
        GreetingThrowsAdvice greetingThrowsAdvice = new GreetingThrowsAdvice();
        badProxy.setTarget(badWaiter);
        badProxy.addAdvice(greetingThrowsAdvice);
        badProxy.setProxyTargetClass(true);//use CGLib
        NaiveWaiter badWaiterProxy = (NaiveWaiter) badProxy.getProxy();

        try {
            badWaiterProxy.fight("Peter");
        }catch (Exception e){

        }

        try {
            badWaiterProxy.blame("Peter");
        } catch (Exception e) {

        }

    }
}
