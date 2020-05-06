package com.smart.proxy;

public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod){
        this.begin = System.currentTimeMillis();
        this.serviceMethod = serviceMethod;
    }

    public void printPerformance(){
        this.end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + ":cost -->" + elapse + "ms");
    }
}
