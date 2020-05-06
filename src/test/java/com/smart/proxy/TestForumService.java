package com.smart.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //create target
        ForumService target = new ForumServiceImpl();
        //create handler
        PerformanceHandler handler = new PerformanceHandler(target);
        //create proxy class
        ForumService proxy = (ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        proxy.removeForum(123);
        proxy.removeTopic(456);
    }
}
