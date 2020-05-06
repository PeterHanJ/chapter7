package com.smart.advice;

public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.service(clientName);
    }

    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }
}
