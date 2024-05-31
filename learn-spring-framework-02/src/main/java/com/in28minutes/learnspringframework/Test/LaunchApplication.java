package com.in28minutes.learnspringframework.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ComponentScan
public class LaunchApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LaunchApplication.class);
        var context2 = new AnnotationConfigApplicationContext(MySQLDataService.class);

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(LaunchApplication.class));
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());

        System.out.println(context2.getBean(MySQLDataService.class));



    }
}
