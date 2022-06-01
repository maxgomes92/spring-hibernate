package com.luv2code.springdemo;

import com.luv2code.springdemo.services.FortuneService;
import com.luv2code.springdemo.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
    @Bean
    FortuneService sadFortuneService () {
        return new SadFortuneService();
    }

    @Bean
    @Scope("prototype")
    public Coach swimCoach () {
        return new SwimCoach(sadFortuneService());
    }
}
