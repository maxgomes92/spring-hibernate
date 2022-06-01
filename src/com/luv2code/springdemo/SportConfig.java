package com.luv2code.springdemo;

import com.luv2code.springdemo.services.FortuneService;
import com.luv2code.springdemo.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SportConfig {
    @Bean
    FortuneService sadFortuneService () {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach () {
        return new SwimCoach(sadFortuneService());
    }
}
