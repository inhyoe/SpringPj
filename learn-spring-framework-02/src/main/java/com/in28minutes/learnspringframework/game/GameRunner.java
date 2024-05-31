package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsoleInterface game;

    @Autowired
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsoleInterface game) {
        this.game = game;
    }

//    public GameRunner(GamingConsoleInterface game, String name){
//        this.game = game;
//    };

    public void up() {
        game.up();
    }

    public void run() {
        System.out.println("Running game: " + game); // 보통은 로깅 프레임워크를 사용하는 것이 좋음
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
