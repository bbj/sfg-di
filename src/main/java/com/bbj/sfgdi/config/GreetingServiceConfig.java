package com.bbj.sfgdi.config;

import com.bbj.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    // here we cannot have method name = service name = i18nService again
    // so we use i18nSpanishGreetingService() which implies we specify
    // bean name using @Bean("i18nService")
    // SPRING USES THE METHOD NAME, UNLESS YOU OVERWRITE IT with @Bean
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService() { //method name = service name
        return new I18nEnglishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() { //constructorGreetingService = name of Bean
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() { //propertyGreetingService = name of Bean
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() { //setterGreetingService = name of Bean
        return new SetterGreetingService();
    }
}
