package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main (String[] args) {
        var context = new AnnotationConfigApplicationContext(SportConfig.class);

        var coach = context.getBean("swimCoach", SwimCoach.class) ;

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
