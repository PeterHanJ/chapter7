package com.smart.proxy.advice;

import com.smart.advice.NaiveWaiter;
import com.smart.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceSpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        Waiter waiter = ctx.getBean("waiter",Waiter.class);
        waiter.greetTo("Peter");
        waiter.service("Peter");

        NaiveWaiter badWaiter = (NaiveWaiter)waiter;

        try {
            badWaiter.fight("Peter");
        } catch (Exception e) {

        }

        try {
            badWaiter.blame("Peter");
        } catch (Exception e) {

        }


    }
}
