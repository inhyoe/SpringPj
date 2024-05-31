package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//record 는 JDK 16에서 추가
//record 를 사용하면 게터, 세터 메서드를 사용할 필요가 없음
record Address(int firstLine, String city) {
}
record  Person ( String name, int age, Address address) { };
;

@Configuration
public class HelloWorldConfiguration {

    // 이 어노테이션은 Bean을 생성하며 이 Bean은 Spring 컨테이너가 관리
    @Bean
    public String name(){
        return "Chang hoon";
    }
    @Bean
    public int age(){
        return 26;
    }

    @Bean int firstLine(){
        return 125;
    }
    @Bean String city(){
        return "東京都葛飾区金町５丁目 ２４−７";
    }

    @Bean
    public Person person(){
        return new Person("gimozzi",20,new Address(224,"Main Street"));
//        person.name(); <- 가능
    }
    @Bean
    @Primary
    // 리턴값이 뭔가인가가 가장 중요함.
    public Person person2MethodCall(){
        return new Person("Primary",age(),new Address(firstLine(),city()));
//        person.name(); <- 가능
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){ //name, age
        return new Person(name,age,address3);
//        person.name(); <- 가능
    }

    @Bean
    public Person person4Parameters(String name, int age, Address address){ //name, age
        return new Person(name,age,address);
//        person.name(); <- 가능
    }

    @Bean
    //현재 내가 사용하고싶은 Bean은 address2 이므로 Qualifier에 그에 맞는 한정자를 접속시켜줘야함.
    public Person person5QualifierString(String name, int age, @Qualifier("address3qualifier") Address address){ //name, age
        return new Person("Qualifier",age,address);
//        person.name(); <- 가능
    }

    @Bean(name = "address2")
    @Primary
    public Address address(){
        return new Address(125,"Primary");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier") // 한정자
    public Address address2(){
        return new Address(200,"Seoul");
    }
//    @Bean
//    public String person(){
//        return "Ranga";
//    }
//    @Bean
//    public String name(){
//        return "Ranga";
//    }

}
