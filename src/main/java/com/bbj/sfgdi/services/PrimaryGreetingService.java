package com.bbj.sfgdi.services;

//@Primary //@Qualifier will take precedence over @Primary
//@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeding() {
        return "Hello world - PRIMARY Bean";
    }
}
