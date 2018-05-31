package com.tutorial;

import com.tutorial.domain.entities.Currency;
import com.tutorial.services.CurrencyService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String... arsg) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        for(Currency c : context.getBean(CurrencyService.class).getAllCurrencies()){
            System.out.println(c.toString());
        }
    }
}
