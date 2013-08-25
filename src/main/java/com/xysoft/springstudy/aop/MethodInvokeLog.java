package com.xysoft.springstudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class MethodInvokeLog {
    public static int count;
    public void logMethodInvokeCount(){
        count++;
        System.out.println("calling count " + count);
    }

    public void printMethodInvokeTime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try {
            System.out.println(joinPoint.getTarget().getClass());
            System.out.println(joinPoint.getSignature().getName());
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost==>"+(end-start)+"ms");
    }
}
