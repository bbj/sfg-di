package com.bbj.sfgdi;

import com.bbj.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bbj.sfgdi", "com.bbj.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		//run() returns a handle to the application context
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("------------ i18nController");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("------------ myController");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

		//show some typical errors
		System.out.println("------------ Property Injected");
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------- Setter Injected");
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---------- Constructor Injected");
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
/*
Run
	Hello World!!!
	Hi Folks!
	------------ Property
	Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'propertyInjectedController' available

in class PropertyInjectedController, if we add @Controller to class => another error
	Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.bbj.sfgdi.services.GreetingService.sayGreeding()"
	because "this.greetingService" is null

If we add @Autowired to greetingService property => another error
	Field greetingService in com.bbj.sfgdi.controllers.PropertyInjectedController
	required a bean of type 'com.bbj.sfgdi.services.GreetingService' that could not be found.

If we add @Service to GreetingServiceImpl, it works!
	Hello World!!!
	Hi Folks!
	------------ Property
	Hello World

 */