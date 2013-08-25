package com.xysoft.springstudy.aop;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-19
 * Time: 下午11:46
 * To change this template use File | Settings | File Templates.
 */
public class NoneSourceClass implements NoneSourceInterface{
    @Override
    public String doBusiness(String name) {
        System.out.println("name is "+name);
        return "www.hust.edu.cn";
    }
}
