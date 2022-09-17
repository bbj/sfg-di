package com.bbj.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary //@Qualifier will take precedence over @Primary
@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeding() {
        return "Hello world - PRIMARY Bean";
    }
}
