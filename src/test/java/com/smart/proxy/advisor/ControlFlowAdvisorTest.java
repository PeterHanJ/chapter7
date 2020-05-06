package com.smart.proxy.advisor;

import com.smart.advice.Waiter;
import com.smart.advice.WaiterDelegate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControlFlowAdvisorTest {
    @Test
    public void controlFlow(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        Waiter waiter4 = ctx.getBean("waiter4",Waiter.class);
        //direct call, will not apply advice
        waiter4.greetTo("peter");
        waiter4.service("peter");
        //call from delegate, apply advice
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter4);
        waiterDelegate.service("Han Jun");

    }
}

