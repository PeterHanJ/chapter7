package com.smart.proxy;

import javax.annotation.PreDestroy;

public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        //PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeTopic");

        System.out.println("Delete topic :" + topicId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();//
        }

        //PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        //PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeForum");

        System.out.println("Delete forum :" + forumId);
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //PerformanceMonitor.end();
    }
}
