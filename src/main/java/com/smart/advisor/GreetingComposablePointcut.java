package com.smart.advisor;

import com.smart.advice.WaiterDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut{
    public Pointcut getIntersectionPointcut(){
        ComposablePointcut cp = new ComposablePointcut();
        Pointcut p1 = new ControlFlowPointcut(WaiterDelegate.class,"service");
        NameMatchMethodPointcut p2 = new NameMatchMethodPointcut();
        p2.addMethodName("greetTo");
        return cp.intersection(p1).intersection((Pointcut) p2);
    }
}
