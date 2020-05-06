package com.smart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GreetingInterceptor implements MethodInterceptor {


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("Ding Dong ------------------ " + clientName);
        Object obj = methodInvocation.proceed();
        System.out.println("Dang Dang ------------------ " + clientName);
        return obj;
    }
}
