package com.smart.proxy.advice;

import com.smart.introduce.Monitorable;
import com.smart.proxy.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroductionInterceptorTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        ForumService forumService = ctx.getBean("forumService",ForumService.class);
        //Performance monitor is disable
        forumService.removeForum(123);
        forumService.removeTopic(456);

        //Performance monitor is enable
        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorActive(true);
        forumService.removeForum(123);
        forumService.removeTopic(456);
    }
}
