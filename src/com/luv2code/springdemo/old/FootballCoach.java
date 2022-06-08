package com.luv2code.springdemo.old;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "My football workout!";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
