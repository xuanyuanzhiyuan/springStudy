package com.xysoft.springstudy.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午8:03
 */
public class SpringBeanUtils<T> implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContext.setContext(applicationContext);
    }
}
