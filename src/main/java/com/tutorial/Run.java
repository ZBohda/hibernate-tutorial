package com.tutorial;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

    public static void main(String... arsg) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    }
}
