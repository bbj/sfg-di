package com.bbj.sfgdi.controllers;

import com.bbj.sfgdi.services.GreetingService;

public class ConstructorInjectedController {
    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService g) {
        this.greetingService = g;
    }

    public String getGreeting() {
        return greetingService.sayGreeding();
    }
}
