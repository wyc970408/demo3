package com.example.demo.test;


import com.example.demo.holidaycheck.TestWorkDay;
import com.example.demo.holidaycheck.WorkDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Jobtest {
    private static final Logger logger= LoggerFactory.getLogger(Jobtest.class);

    // @Scheduled(cron = "0/5 * * * * ?")
    public void Job1(){
        String truething ="今天要上班！";
        String falsething ="今天不用上班";
        //String path="D:readExcel.xls";
        WorkDay workDay = new WorkDay();
        System.out.println("定时任务：检查今天是否上班！");
        //workDay.JuageMentTest(truething, falsething);
    }

    @Scheduled(cron = "0 33 17 * * 1")
    public void Job2() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateFormat.format(new Date()));
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Date date1 = dateFormat1.parse(dateFormat1.format(new Date()));
            System.out.println("定时任务2：下班提醒");
            System.out.println(date1);
            String string = "下班了！";
            System.out.println(string);
        } catch (ParseException e) {
            e.getStackTrace();
        }
    }

    @Scheduled(cron = "0 30 12 * * ? ")
    public void Job3() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateFormat.format(new Date()));
            System.out.println(date);
            System.out.println("定时任务3：中午打卡提醒");
            String string = "该打卡了！！！！";
            System.out.println(string);
            System.out.println();
        } catch (ParseException e) {
            e.getStackTrace();
        }

    }
}
