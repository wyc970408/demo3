package com.example.demo.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@Configuration
public class App {
    private static final Logger logger= LoggerFactory.getLogger(App.class);
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
        logger.info("oops");


    }
}
