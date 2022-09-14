package com.bbj.sfgdi;

import com.bbj.sfgdi.controllers.ConstructorInjectedController;
import com.bbj.sfgdi.controllers.MyController;
import com.bbj.sfgdi.controllers.PropertyInjectedController;
import com.bbj.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		//run() returns a handle to the application context
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

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