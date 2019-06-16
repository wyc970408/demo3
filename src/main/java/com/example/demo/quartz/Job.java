package com.example.demo.quartz;

import com.example.demo.holidaycheck.TestWorkDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Job {
    private static final Logger logger= LoggerFactory.getLogger(Job.class);
    @Scheduled(cron = "0 0/5 8-20 * * ?")
    public void task(){

        String truething ="今天要上班！";
        String falsething ="今天不用上班";
        String path="D://readExcel.xls";
        TestWorkDay testWorkDay =new TestWorkDay();
        testWorkDay.JudgmentDate(path,truething,falsething);
    }
}
