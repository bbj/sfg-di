package com.bbj.sfgdi.services;

//@Service config moved to com.bbj.sfgdi.config.GreetingServiceConfig, performance reason
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }
}
