package com.xysoft.springstudy.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * User: jinyanhua
 * Date: 13-8-25
 * Time: 下午7:55
 */
@Service
public class SysJobs {

    @Scheduled(fixedRate = 3000)
    public void processScheduleJob(){
        System.out.println("start process job...");
        System.out.println("end....");
    }
}
