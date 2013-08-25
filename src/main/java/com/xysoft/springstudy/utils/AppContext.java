package com.xysoft.springstudy.utils;

import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午11:03
 * To change this template use File | Settings | File Templates.
 */
public class AppContext {
    private static ApplicationContext context;

    public static void setContext(ApplicationContext ctx){
        context = ctx;
    }

    public static Object getBean(String beanId){
        return context.getBean(beanId);
    }
}
