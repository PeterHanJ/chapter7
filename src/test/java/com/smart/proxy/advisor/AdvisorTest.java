package com.smart.proxy.advisor;

import com.smart.advice.NaiveWaiter;
import com.smart.advice.Seller;
import com.smart.advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        //static method match
        Waiter waiter1 = ctx.getBean("waiter1",Waiter.class);
        Seller seller1 = ctx.getBean("seller1",Seller.class);

        waiter1.greetTo("peter");
        seller1.greetTo("peter");

        //regexp method match
        Waiter waiter2 = ctx.getBean("waiter2",Waiter.class);
        waiter2.greetTo("Han Jun");
    }
}
