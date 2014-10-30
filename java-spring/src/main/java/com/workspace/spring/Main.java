package com.workspace.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepak on 10/30/14.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});

        Transaction t = (Transaction) context.getBean("transBean");
        System.out.println(t.getMessage());

    }
}
