package com.example.demo.holidaycheck;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestUtil {
    public JSONObject load(String url) throws Exception {
        URL restURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) restURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line, resultStr = "";

        while (null != (line = bufferedReader.readLine())) {

            resultStr += line;

        }
        bufferedReader.close();
        JSONObject jsonObject = new JSONObject(resultStr);
        return jsonObject;
    }
}
