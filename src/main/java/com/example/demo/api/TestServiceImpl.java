package com.example.demo.api;


import com.example.demo.holidaycheck.RestUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public void JuageMentTest(String date, String truething, String falsething) {
        int i = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            RestUtil restUtil = new RestUtil();
            String url = "http://api.goseek.cn/Tools/holiday?date=" + date;
            JSONObject resultString = restUtil.load(url);
            Object data = resultString.get("data");
            i = Integer.parseInt(data.toString());
            if (i == 0 || i == 2) {
                System.out.println(truething);
            } else
                System.out.println(falsething);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
