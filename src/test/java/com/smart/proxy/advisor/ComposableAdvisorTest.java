package com.smart.proxy.advisor;

import com.smart.advice.Waiter;
import com.smart.advice.WaiterDelegate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComposableAdvisorTest {
    @Test
    public void composablePointcut(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        Waiter waiter5 = ctx.getBean("waiter5",Waiter.class);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter5);
        waiterDelegate.service("Han Jun");

    }
}

