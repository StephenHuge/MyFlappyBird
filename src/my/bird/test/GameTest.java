package my.bird.test;

import my.bird.game.Game;

public class GameTest {
    public static void main(String[] args) {
        Game fb = new Game();
        System.out.println(fb);
        
        fb.start();
        fb.pause();
        fb.continuea();
        fb.over();
        fb.restart();
    }
}
