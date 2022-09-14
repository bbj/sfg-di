package com.bbj.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeding() {
        return "Hello World - Setter";
    }
}
