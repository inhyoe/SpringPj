package com.in28minutes.learnspringframework.example.a0;

import com.in28minutes.learnspringframework.example.a1.DepInjectionLauncherApplication;
import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//class YourBusinessClass{}
//
//@Component
//class Dependency1{}
//
//@Component
//class Dependency2{}

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class SpringSimpleContextLauncherApplication {
    public static void main(String[] args) {
        // 여기서 DepInjectionLauncherApplication.class 대신 SpringSimpleContextLauncherApplication.class를 사용합니다.
        var context = new AnnotationConfigApplicationContext(SpringSimpleContextLauncherApplication.class);

        context.getBean(GamingConsoleInterface.class).up();

        context.getBean(GameRunner.class).run();

        // Spring 컨텍스트에서 어떤 Bean이 쓰였는지 확인하려면
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}