package my.bird.flappy;

import java.awt.Color;
import java.awt.Font;

import org.junit.Test;

import edu.princeton.cs.algs4.StdDraw;

public class Game {
    private Bird bird;
    private Wall[] walls;
    private int score =0;
    private int grade = 0;
    private boolean paused = false;

    public Game() {
    }

    /**
     * game's entrance
     */
    @Test
    public void start() {   
        StdDraw.setPenRadius(0.05);
        while(true) {
            mainPage();     // start page
            running();         // running page
            gameOver();     // end page
        }
    }

    /**
     * start/main page of this game, press SPACE to start the game
     */
    private void mainPage() {
        StdDraw.clear();
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(Color.BLACK);
        while(true) {
            StdDraw.text(0.5, 0.7, "Main Page");
            StdDraw.text(0.5, 0.6, "Press space to start");
            if(StdDraw.isKeyPressed(0x20))  break;
        }


    }

    /**
     * running page of this game
     */
    private void running() {
        StdDraw.setPenRadius(0.05);
        bird = new Bird();
        while(true) {
            if (!bird.isAlive())  break;
            if (paused  && bird.isAlive()) {
                pause();
            }
            if (!paused && bird.isAlive()) {
               play();
            }
            if(StdDraw.isKeyPressed(0x50)) {
                paused = !paused;
                StdDraw.pause(100);
            }
            
        }
        Utils.clear();
    }

    private void pause() {
        StdDraw.text(0.5, 0.7, "PAUSED");
    }

    private void play() {
        draw();
        judgeAlive();
        StdDraw.pause(80);
        bird.move();
        grade++;
        if (grade % 33 == 0) {
            score += 1;
            grade = 10;
        }
        if (StdDraw.isKeyPressed(0x20)) {
            bird.jump();
        }
        StdDraw.clear();
    }
    /**
     * end page of this game, if the bird is not alive, then game is over
     */
    private void gameOver() {
        StdDraw.clear();
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(Color.MAGENTA);
        while(true) {
            StdDraw.text(0.5, 0.7, "GAME OVER!");
            StdDraw.text(0.5, 0.6, "YOUR SCORE IS " + score);
            StdDraw.text(0.5, 0.5, "Press enter to return");
            if(StdDraw.isKeyPressed('\n')) {
                score = 0;
                break;
            }
        }
    }

    /**
     * when game running, draw bird, walls and score  
     */
    private void draw() {
        //        StdDraw.clear();
        bird.draw();
        walls = Utils.getWalls();
        for (Wall wall: walls) {    wall.draw();    }
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.setFont(new Font("", Font.BOLD, 15));
        StdDraw.textRight(0.9, 0.9, score + "");
    }

    /**
     * judge whether the bird is alive
     */
    private void judgeAlive() {
        for (Wall wall: walls) {
            double bX = bird.getxAxis();
            double bY = bird.getyAxis();
            double wX = wall.getxAxis();
            double wAY = wall.getAboveYAxis();
            double wBY = wall.getBelowYAxis();
            if (Math.abs(wX - bX) < 0.01 ) {
                if (bY >= wAY || bY <= wBY) {   bird.setAlive(false);   } 
            } else if(bird.getyAxis() <= 0 || bird.getyAxis() >= 1.0) {
                bird.setAlive(false);
            } 
        }
    }
}
