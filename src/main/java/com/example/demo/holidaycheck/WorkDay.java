package com.example.demo.holidaycheck;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkDay {

    public void JuageMentTest(String truething, String falsething) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = dateFormat.parse(dateFormat.format(new Date()));
            System.out.println("今天是" + dateFormat.format(new Date()));
            // System.out.println(date);
            RestUtil restUtil = new RestUtil();
            String url = "http://api.goseek.cn/Tools/holiday?date=" + dateFormat.format(new Date());
            JSONObject resultString = restUtil.load(url);
            Object data = resultString.get("data");
            int i = Integer.parseInt(data.toString());

            // System.out.println(data.toString());
            if (i == 0 || i == 2) {
                System.out.println(truething);
            } else
                System.out.println(falsething);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
