package com.smart.proxy.advisor;

import com.smart.advice.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicAdvisorTest {

    @Test
    public void dynamic(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        Waiter waiter3 = ctx.getBean("waiter3",Waiter.class);
        waiter3.service("Peter");
        waiter3.greetTo("Han Jun");
        waiter3.greetTo("Peter");
        waiter3.greetTo("Tom");
    }

}
