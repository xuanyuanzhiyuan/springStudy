package com.xysoft.testdriven;

/**
 * User: jinyanhua
 * Date: 13-11-3
 * Time: 上午11:30
 */
public class TicketRevenue {

    public static final int PRICE = 30;

    public long calculate(int i) {
        return (long) PRICE *i;
    }
}
