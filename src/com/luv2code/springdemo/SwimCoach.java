package com.luv2code.springdemo;

import com.luv2code.springdemo.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


public class SwimCoach implements Coach {
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

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

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
