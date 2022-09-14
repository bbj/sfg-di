package com.bbj.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeding() {
        return "Hello World - Property";
    }
}
