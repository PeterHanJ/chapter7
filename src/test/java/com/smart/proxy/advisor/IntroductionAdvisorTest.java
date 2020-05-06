package com.smart.proxy.advisor;

import com.smart.introduce.Monitorable;
import com.smart.proxy.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroductionAdvisorTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        ForumService forumService2 = ctx.getBean("forumService2",ForumService.class);
        //Performance monitor is disable
        forumService2.removeForum(123);
        forumService2.removeTopic(456);

        //Performance monitor is enable
        Monitorable monitorable = (Monitorable)forumService2;
        monitorable.setMonitorActive(true);
        forumService2.removeForum(123);
        forumService2.removeTopic(456);
    }
}
