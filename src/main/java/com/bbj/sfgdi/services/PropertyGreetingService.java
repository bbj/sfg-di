package com.bbj.sfgdi.services;

//@Service config moved to com.bbj.sfgdi.config.GreetingServiceConfig, performance reason
public class PropertyGreetingService implements GreetingService {

    @Override
    public String sayGreeding() {
        return "Hello World - Property";
    }
}
