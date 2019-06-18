package com.example.demo.api;


import com.example.demo.holidaycheck.WorkDay;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("check")
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(@RequestParam String params) {
        WorkDay workDay = new WorkDay();
        String truething = "今天需要上班";
        String falsething = "今天放假";
        String k = workDay.JuageMentTest(params, truething, falsething);
        return k;
    }

}
