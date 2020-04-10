package com.lrw;

import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LeecodetestApplication {

    public static void main(String[] args)
    {
        //new ClassPathXmlApplicationContext();
        //new DefaultSingletonBeanRegistry();
        SpringApplication.run(LeecodetestApplication.class, args);
    }

}
