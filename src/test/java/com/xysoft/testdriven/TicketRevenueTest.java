package com.xysoft.testdriven;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: jinyanhua
 * Date: 13-11-3
 * Time: 上午11:20
 */
public class TicketRevenueTest {
    private TicketRevenue tr;

    @Before
    public void setUp(){
        tr = new TicketRevenue();
    }

    @Test
    public void testOneTicketRevenue(){
       long expectMoney = 30;
       assertEquals(expectMoney,tr.calculate(1));
    }

    @Test
    public void testTenTicketRevenue(){
        long expectMoney = 300;
        assertEquals(expectMoney,tr.calculate(10));
    }
}
