package com.vik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadProperties {

    public static void main(final String args[]) {

        System.out.println("Inside Read Properties");

        // System.setProperty("personName", args[0]);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/app-context.xml");

        System.out.println(((Person) ctx.getBean("person")).getFirstName());

        // System.out.println(((Configuration) ctx.getBean("config")).getName());
    }

}
