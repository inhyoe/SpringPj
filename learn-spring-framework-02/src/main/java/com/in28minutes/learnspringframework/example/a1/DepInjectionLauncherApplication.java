package com.in28minutes.learnspringframework.example.a1;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {

    Dependency1 dependency1;
    Dependency2 dependency2;
    // 생성자 인젝션 @Autowired 추가하지 않아도 됨
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2){
        super();
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

//    // 세터 인젝셩
//    @Autowired
//    public void setDependency1(Dependency1 dependency1){
//        System.out.println("Setter Injection - setDependency1");
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2){
//        System.out.println("Setter Injection - setDependency2");
//        this.dependency2 = dependency2;
//    }

    //의존성 주입
    //필드 인젝션, 세터, 생성자 없음
    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);
        context.getBean(GamingConsoleInterface.class).up();

        context.getBean(GameRunner.class).run();

        // Spring 컨텍스트에서 어떤 Bean이 쓰였는지 확인하려면
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(YourBusinessClass.class));

    }
}
