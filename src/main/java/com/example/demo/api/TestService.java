package com.example.demo.api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public interface TestService {
    public void JuageMentTest(String date, String truething, String falsething);
}
