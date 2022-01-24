package com.forthreal;

import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args)
    {
        var applicationContext = new ClassPathXmlApplicationContext("integration/integration.xml");

        var application = new SpringApplication( AppMain.class );
        application.run(args);


    }

}
