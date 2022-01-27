package com.forthreal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AppMain {
    public static void main(String[] args)
    {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/integration/integration.xml");

        var application = new SpringApplication( AppMain.class );
        application.run(args);


    }

}
