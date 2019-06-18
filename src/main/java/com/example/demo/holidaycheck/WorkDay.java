package com.example.demo.holidaycheck;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkDay {

    public String JuageMentTest(String date, String truething, String falsething) {
        String flag = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            //Date date = dateFormat.parse(dateFormat.format(new Date()));
            // System.out.println("今天是" + dateFormat.format(new Date()));
            // System.out.println(date);
            RestUtil restUtil = new RestUtil();
            String url = "http://api.goseek.cn/Tools/holiday?date=" + date; //dateFormat.format(new Date());
            JSONObject resultString = restUtil.load(url);
            Object data = resultString.get("data");
            int i = Integer.parseInt(data.toString());

            //System.out.println(data.toString());
            if (i == 0 || i == 2) {
                //System.out.println(truething);
                flag = truething;
            } else {
                //System.out.println(falsething);
                flag = falsething;
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            return flag;
        }
    }
}
