package com.bbj.sfgdi.controllers;

import com.bbj.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired //tell Spring we want this property to be used for dependency
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeding();
    }
}
