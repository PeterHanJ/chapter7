package com.smart.proxy;

import com.smart.cglibproxy.CglibProxy;
import org.springframework.cglib.core.DebuggingClassWriter;

public class TestForumCGProxy {
    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\IdeaProjects\\chapter7\\target\\classes\\com\\smart\\cglibproxy");
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl service = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        service.removeForum(123);
        service.removeTopic(456);
    }
}
