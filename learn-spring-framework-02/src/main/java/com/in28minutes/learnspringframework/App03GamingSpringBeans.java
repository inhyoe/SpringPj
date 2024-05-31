package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game") // Component (Bean)을 찾는 것 없으면 Spring이 컴포넌트를 찾지 못함.
public class App03GamingSpringBeans {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class);

        context.getBean(GamingConsoleInterface.class).up();

        context.getBean(GameRunner.class).run();

    }
}
