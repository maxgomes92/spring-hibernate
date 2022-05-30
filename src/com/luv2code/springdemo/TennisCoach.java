package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
    @Autowired // Uses reflection
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired
    public TennisCoach () {
        System.out.println("TennisCoach constructor");
    }

    @PostConstruct
    private void postConstruct () {
        System.out.println("Post construct Coach!");
    }

    @PreDestroy
    private void preDestroy () { System.out.println("Pre-destroy Coach!");}

    @Override
    public String getDailyWorkout() {
        return "My tennis workout!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
}
