package com.smart.advice;

import java.sql.SQLException;

public class NaiveWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("Greet to " + name);
    }

    public void service(String name) {
        System.out.println("serving " + name + "...");
    }

    public void fight(String name){
        throw new RuntimeException("fighting..." + name);
    }

    public void blame(String name) throws Exception{
        throw new SQLException("sorry..."+ name);
    }
}
