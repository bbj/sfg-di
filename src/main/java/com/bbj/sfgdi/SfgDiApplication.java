package com.bbj.sfgdi;

import com.bbj.sfgdi.config.SfgConfiguration;
import com.bbj.sfgdi.config.SfgConstructorConfig;
import com.bbj.sfgdi.controllers.*;
import com.bbj.sfgdi.datasource.FakeDataSource;
import com.bbj.sfgdi.services.PrototypeBean;
import com.bbj.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"com.bbj.sfgdi", "com.bbj.pets"})
//not needed anymore as pet config is moved to java config in GreetingServiceConfig => no more scan needed in pets
//@ImportResource("classpath:sfgdi-config.xml") <=== we put it in Java Config Class: GreetingServiceConfig
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		//run() returns a handle to the application context
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

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

		System.out.println("----------- Bean Scopes -------------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class); //referenced by class
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("-------------- FakeDataSource -------");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

		System.out.println("-------------- Config Props Binding Bean -------");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcUrl());

		System.out.println("-------------- Constructor Props Binding Bean -------");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcUrl());
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