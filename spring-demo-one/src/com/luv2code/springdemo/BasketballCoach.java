package com.luv2code.springdemo;

public class BasketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Basketball Coach running";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
