package com.bbj.sfgdi.controllers;

import com.bbj.sfgdi.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeding();
    }
}
