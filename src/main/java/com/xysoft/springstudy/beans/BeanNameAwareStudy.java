package com.xysoft.springstudy.beans;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class BeanNameAwareStudy implements BeanNameAware {
    private String beanName;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }
}
