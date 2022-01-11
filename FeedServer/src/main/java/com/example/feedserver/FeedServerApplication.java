package com.example.feedserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class FeedServerApplication {
    public static ConfigurableApplicationContext starter;
    public static void main(String[] args) {
        int counter = 0;
        for (String arg :
                args) {
            counter++;
            System.out.println(counter + ". " + arg);
        }
        starter = SpringApplication.run(FeedServerApplication.class, args);
        System.out.println("http://localhost:8080/explorer/index.html#theme=Litera&uri=/");
    }
}
