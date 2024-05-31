package com.in28minutes.learnspringframework.example.f1;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;

        System.out.println("All dependencies are Ready!");
    }

    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp2(){
        someDependency.cleanup();
    }
    
    @PreDestroy
    public void cleanUp(){
        System.out.println("it Cleaned up");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("기모찌");
    }

    public void cleanup() {
        System.out.println("Clean up");
    }
}

@Configuration
@ComponentScan()
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {
        // 여기서 DepInjectionLauncherApplication.class 대신 SpringSimpleContextLauncherApplication.class를 사용합니다.
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class);

        // Spring 컨텍스트에서 어떤 Bean이 쓰였는지 확인하려면
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}