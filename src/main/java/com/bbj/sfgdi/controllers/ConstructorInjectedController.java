package com.bbj.sfgdi.controllers;

import com.bbj.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    //Since the constructor is the only way to initialize this, we do not need to tell Spring utilize it
    public ConstructorInjectedController(GreetingService g) {
        this.greetingService = g;
    }

    public String getGreeting() {
        return greetingService.sayGreeding();
    }
}
