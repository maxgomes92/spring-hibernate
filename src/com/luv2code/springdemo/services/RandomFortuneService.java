package com.luv2code.springdemo.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = { "My fortune 1", "My fortune 2", "My fortune 3" };

    @Override
    public String getFortune() {
        var index = new Random().nextInt(fortunes.length);
        return fortunes[index];
    }
}
