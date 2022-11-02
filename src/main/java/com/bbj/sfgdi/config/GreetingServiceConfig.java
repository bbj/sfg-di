package com.bbj.sfgdi.config;

import com.bbj.pets.PetService;
import com.bbj.pets.PetServiceFactory;
import com.bbj.sfgdi.datasource.FakeDataSource;
import com.bbj.sfgdi.repositories.EnglishGreetingRepository;
import com.bbj.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.bbj.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${bbj.username}") String username,
                                  @Value("${bbj.password}") String password,
                                  @Value("${bbj.jdbcUrl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    //for this below, we need in application.properties: spring.profiles.active=cat,EN
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    // here we cannot have method name = service name = i18nService again
    // so we use i18nSpanishGreetingService() which implies we specify
    // bean name using @Bean("i18nService")
    // SPRING USES THE METHOD NAME, UNLESS YOU OVERWRITE IT with @Bean
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) { //method name = service name
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    this bean is moved to XML configuration file, so we remove annotation
//    and add annotation at the class level above to tell Spring to look in config XML file
//    @Bean
//    ConstructorGreetingService constructorGreetingService() { //constructorGreetingService = name of Bean
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyGreetingService propertyGreetingService() { //propertyGreetingService = name of Bean
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() { //setterGreetingService = name of Bean
        return new SetterGreetingService();
    }
}
