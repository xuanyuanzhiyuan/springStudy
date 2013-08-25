package com.xysoft.springstudy.jmx;

/**
 * User: jinyanhua
 * Date: 13-8-25
 * Time: 下午5:01
 */
public class SysParamBean {
    private int DEFAULT_PAGE_SIZE = 20;
    private String DEFAULT_NAME = "MyApp";

    public int getDEFAULT_PAGE_SIZE() {
        return DEFAULT_PAGE_SIZE;
    }

    public void setDEFAULT_PAGE_SIZE(int DEFAULT_PAGE_SIZE) {
        this.DEFAULT_PAGE_SIZE = DEFAULT_PAGE_SIZE;
    }

    public String getDEFAULT_NAME() {
        return DEFAULT_NAME;
    }

    public void setDEFAULT_NAME(String DEFAULT_NAME) {
        this.DEFAULT_NAME = DEFAULT_NAME;
    }
}
