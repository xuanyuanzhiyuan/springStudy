package com.xysoft.springstudy.aop;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-19
 * Time: 下午11:49
 * To change this template use File | Settings | File Templates.
 */
public class TargetServiceImpl implements TargetService {
    @Override
    public String myNewService(String name) {
        return "this is more ability: " + name;
    }
}
