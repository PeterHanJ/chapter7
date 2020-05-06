package com.smart.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * ThrowsAdvice not declare any method to be implemented
 * Method Name : afterThrowing
 * Args:
 *  Optional:
 *      method,args,target (Must declare together)
 *  Mandatory:
 *      exception (Throwable or subclass)
 */
public class GreetingThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,Object[] args,Object target,RuntimeException ex) throws Throwable{
        System.out.println("-----------------------");
        System.out.println("method:"+method.getName());
        System.out.println("exception:" + ex.getMessage());

    }

    public void afterThrowing(SQLException ex) throws Throwable{
        System.out.println("-------------------------");
        System.out.println("exception:"+ ex.getMessage());
    }
}
