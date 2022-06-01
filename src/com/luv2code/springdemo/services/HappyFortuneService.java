package com.luv2code.springdemo.services;

import com.luv2code.springdemo.services.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "My happy fortune";
    }
}
