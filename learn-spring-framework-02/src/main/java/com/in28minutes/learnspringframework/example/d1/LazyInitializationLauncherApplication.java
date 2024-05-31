package com.in28minutes.learnspringframework.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class ClassA{}

@Component
//@Lazy
class ClassB{
    private  ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some Logic here");
        this.classA = classA;
    }
}
//
//@Component
//class Dependency2{}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)
        ){

            System.out.println("Initialization of context is completed");
            context.getBean(ClassB.class);

        }
    }
}