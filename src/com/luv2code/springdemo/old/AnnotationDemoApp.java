package com.luv2code.springdemo.old;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main (String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        var coach = context.getBean("tennisCoach", TennisCoach.class) ;
        var coachB = context.getBean("tennisCoach", TennisCoach.class) ;

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
