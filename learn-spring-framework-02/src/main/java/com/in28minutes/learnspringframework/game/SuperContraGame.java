package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsoleInterface {
    public void up(){
        System.out.println("up");
    }

    public void down(){
        System.out.println("Sit down");
    }

    public void left(){
        System.out.println("go back");
    }

    public void right(){
        System.out.println("Shoot a bullet");
    }

}
