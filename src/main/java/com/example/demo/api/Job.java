package com.example.demo.api;

public class Job {


    private String jobDay;
    private String trueThing;
    private String falseThing;


    public String getJobDay() {
        return jobDay;
    }

    public void setJobDay(String jobDay) {
        this.jobDay = jobDay;
    }

    public String getTrueThing() {
        return trueThing;
    }

    public void setTrueThing(String trueThing) {
        this.trueThing = trueThing;
    }

    public String getFalseThing() {
        return falseThing;
    }

    public void setFalseThing(String falseThing) {
        this.falseThing = falseThing;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobDay='" + jobDay + '\'' +
                ", trueThing='" + trueThing + '\'' +
                ", falseThing='" + falseThing + '\'' +
                '}';
    }
}
