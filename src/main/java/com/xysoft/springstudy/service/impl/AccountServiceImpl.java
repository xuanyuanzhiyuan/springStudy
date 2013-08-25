package com.xysoft.springstudy.service.impl;

import com.xysoft.springstudy.service.AccountService;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午9:54
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void regNewAccount(String name, String pwd) {
        System.out.println("business==>"+name+" : " + pwd);
    }
}
