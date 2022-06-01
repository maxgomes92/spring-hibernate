package com.luv2code.springdemo;

import com.luv2code.springdemo.services.FortuneService;

public class SwimCoach implements Coach {

    private final FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim daily!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
