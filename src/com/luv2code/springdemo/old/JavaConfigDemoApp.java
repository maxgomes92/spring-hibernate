package com.luv2code.springdemo.old;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main (String[] args) {
        var context = new AnnotationConfigApplicationContext(SportConfig.class);

        var coach = context.getBean("swimCoach", SwimCoach.class) ;
        var coachB = context.getBean("swimCoach", SwimCoach.class) ;

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        System.out.println(coach == coachB);

        System.out.println(coach.getEmail());

        context.close();
    }
}
