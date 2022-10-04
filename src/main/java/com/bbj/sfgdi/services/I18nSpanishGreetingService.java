package com.bbj.sfgdi.services;

//@Profile({"ES", "default"})
//@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
