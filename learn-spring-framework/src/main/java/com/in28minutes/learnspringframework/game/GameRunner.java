package com.in28minutes.learnspringframework.game;

public class GameRunner {
    GamingConsoleInterface game;
    public GameRunner(GamingConsoleInterface game) {
        this.game = game;
    }

    public void  up(){
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
