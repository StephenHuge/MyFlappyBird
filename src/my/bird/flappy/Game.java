package my.bird.flappy;

import java.awt.Color;
import java.awt.Font;

import org.junit.Test;

import edu.princeton.cs.algs4.StdDraw;

public class Game {
    private Bird bird;
    private Wall[] walls;
    private int score = 0;

    public Game() {
    }

    @Test
    public void start() {
        StdDraw.setPenRadius(0.05);
        while(true) {
            mainPage();
            play();
            gameOver();
        }
    }

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

    private void play() {
        StdDraw.clear();
        StdDraw.setPenRadius(0.05);
        bird = new Bird();
        int count = 0;
        while(true) {
            bird.draw();
            walls = Utils.getWalls();
            for(Wall wall: walls) {
                wall.draw();
            }
            StdDraw.setPenColor(Color.DARK_GRAY);
            StdDraw.setFont(new Font("", Font.BOLD, 15));
            StdDraw.textRight(0.9, 0.9, score + "");
            for(Wall wall: walls) {
                double bX = bird.getxAxis();
                double bY = bird.getyAxis();
                double wX = wall.getxAxis();
                double wAY = wall.getAboveYAxis();
                double wBY = wall.getBelowYAxis();
                if(Math.abs(wX - bX) < 0.01 ) {
                    if (bY >= wAY || bY <= wBY) {
//                        System.out.println("bird: " + bX + ", " + bY);
//                        System.out.println("wall above: " + wX + ", " + wAY);
//                        System.out.println("wall below: " + wX + ", " + wBY);
                        bird.setAlive(false);
                    } 
                } else if(bird.getyAxis() <= 0 || bird.getyAxis() >= 1.0) {
                    bird.setAlive(false);
                } 
            }
            if(!bird.isAlive()) break;
            StdDraw.pause(80);
            bird.move();
            count++;
            if(count % 33 == 0) {
                score += 1;
                count = 0;
            }
            if(StdDraw.isKeyPressed(0x20)) {

                bird.jump();
            }
            StdDraw.clear();   
        }
        Utils.clear();
    }
}
