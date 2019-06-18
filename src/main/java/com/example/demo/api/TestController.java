package com.example.demo.api;


import com.example.demo.holidaycheck.WorkDay;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("check")
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(@RequestParam String params) {
        TestServiceImpl testService = new TestServiceImpl();
        String truething = "1";
        String falsething = "0";
        return testService.JuageMentTest(params, truething, falsething);
    }

}
