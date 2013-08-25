package com.xysoft.springstudy.controller;

import com.google.common.collect.Lists;
import com.xysoft.springstudy.aop.NoneSourceClass;
import com.xysoft.springstudy.aop.NoneSourceInterface;
import com.xysoft.springstudy.aop.TargetService;
import com.xysoft.springstudy.beans.BeanNameAwareStudy;
import com.xysoft.springstudy.service.AccountService;
import com.xysoft.springstudy.utils.AppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jinyanhua
 * Date: 13-8-18
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestController {

    @Autowired
    AccountService accountService;

    @Autowired
    NoneSourceInterface service;

    @RequestMapping(value="/regNewUser",params="method=regNewUser")
    public String regNewUser(String username,String pwd,Map<String,Object> model){
        accountService.regNewAccount(username,pwd);
        model.put("name","jinyanhua");
        model.put("age","31");
        model.put("lover","wwwhusteducn");
        List<String> devices = Lists.newArrayList("iPhone","iPod Touch","iMac","iPad","Apple TV");
        model.put("devices",devices);
        return "json";
    }

    @RequestMapping(value="/testaop",params="method=testaop")
    public String testAop(){
        TargetService targetService = (TargetService) service;
        String result = targetService.myNewService("test");
        System.out.println(result);
        return "json";
    }
}
