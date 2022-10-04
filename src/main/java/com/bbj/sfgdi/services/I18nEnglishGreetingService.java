package com.bbj.sfgdi.services;

//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeding() {
        return "Hello World - EN";
    }
}
