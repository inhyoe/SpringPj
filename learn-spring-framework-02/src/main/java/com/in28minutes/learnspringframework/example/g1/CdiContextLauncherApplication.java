package com.in28minutes.learnspringframework.example.g1;

import com.in28minutes.learnspringframework.example.f1.PrePostAnnotationsContextLauncherApplication;
import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService{
    private DataService dataService;


    public DataService getDataService() {
        return dataService;
    }

    //@Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
        System.out.println("Setter Injection");
    }
}


//@Component
@Named
class DataService{

}
@Configuration
@ComponentScan()
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        // 여기서 DepInjectionLauncherApplication.class 대신 SpringSimpleContextLauncherApplication.class를 사용합니다.
        var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class);

        // Spring 컨텍스트에서 어떤 Bean이 쓰였는지 확인하려면
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
}
