package com.smart.advisor;

import com.smart.advice.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();
    static{
        specialClientList.add("Peter");
        specialClientList.add("Tom");
    }

    //filter class - static class match
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                System.out.println("Call getClassFilter() -->" + clazz.getName() + " static check");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    //filter method - static method match
    public boolean matches(Method method,Class<?> targetClass){
        System.out.println("Call matches(method,clazz) -->" + targetClass.getName() + "."+ method.getName() + " static check");
        return "greetTo".equals(method.getName());
    }

    //filter method - dynamic method match
    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        System.out.println("Call matches(method,clazz) -->" + targetClass.getName() + "."+ method.getName() + " dynamic check");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }
}
