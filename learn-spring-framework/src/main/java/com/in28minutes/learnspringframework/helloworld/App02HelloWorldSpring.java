package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 2. Java SpringFramework 시작하기
public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //already have JVM but here is SpringFrameWork
        //1: Launch a Spring Context
        try(var context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            //2: Configure we want Spring to manage - @Configuration ( 설정 )
            // HelloWorldConfiguration - @Configuration
            //name - @Bean

            //3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("address3"));

            // 이 문제를 해결하기 위해서는 기본(Primary)Bean 를 설정해줘야함 )
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));

            System.out.println("한정자(Qualifier) 사용 : "+context.getBean("person5QualifierString"));
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            // Bean 목록 확인

//        System.out.println(context.getBean((Person.class)));
//        System.out.println(context.getBean("person").getClass().getName());
        };


        // AnnotationConfigApplicationContext 은 JVM내 Spring 컨텍스트가 들어가는 방식


    }
}
