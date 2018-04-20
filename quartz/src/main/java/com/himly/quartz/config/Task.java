package com.himly.quartz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 *
 */
@Configuration
@Component
@EnableScheduling
public class Task {

    private void sayHello() {

        System.out.println("hello hello22222222");
    }

    private void sayHello1() {

        System.out.println("hello hello,111111111111");
    }
}
