package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsoleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App03GamingSpringBeans {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

//        System.out.println(context.getBean(GamingConsole.class));
        context.getBean(GamingConsoleInterface.class).up();

        context.getBean(GameRunner.class).run();



//        var game = new MarioGame();
//        var game = new SuperContraGame();
        // var game = new PacmanGame(); // 1: Object Creation 객체 생성

        // var gameRunner = new GameRunner(game);
        // 2: Object Creation + Wiring of Dependencies 종속성 결합
        // GameConsole is a Dependency of GameRunner 게이밍 콘솔은 GameRunner 클래스의 의존성
        // game(Pacman Mario ... ) 클래스(객체)는 생성되고 GameRunner 클래스에 주입됨.
        // gameRunner.run();

    }
}
