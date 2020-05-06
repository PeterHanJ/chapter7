package com.smart.proxy.autoproxy;

import com.smart.advice.Seller;
import com.smart.advice.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameAutoProxyTest {
    @Test
    public void beanNameAutoProxy(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context-beanname-proxy.xml");
        Waiter waiter = ctx.getBean("waiter",Waiter.class);
        Seller seller = ctx.getBean("seller",Seller.class);

        waiter.greetTo("peter");
        waiter.service("peter");

        seller.greetTo("han jun");
    }
}
