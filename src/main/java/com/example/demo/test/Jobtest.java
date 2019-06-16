package com.example.demo.test;


import com.example.demo.holidaycheck.TestWorkDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Jobtest {
    private static final Logger logger= LoggerFactory.getLogger(Jobtest.class);
    @Scheduled(cron = "0/10 * * * * ?")
    public void Job1(){
        String truething ="今天要上班！";
        String falsething ="今天不用上班";
        String path="D://readExcel.xls";
        TestWorkDay testWorkDay =new TestWorkDay();
        System.out.println("定时任务：检查今天是否上班！");
        testWorkDay.JudgmentDate(path,truething,falsething);
    }

}
