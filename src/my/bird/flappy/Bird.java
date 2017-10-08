package my.bird.flappy;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;


/**
 * a Bird class
 * 
 * @author HJS
 *
 * @date 2017年10月8日
 */
public class Bird {
    private Color color;    // color of this bird

    private double xAxis;    // X axis of this bird

    private double yAxis;    // Y axis of this bird

    private boolean alive;  // life state of this bird

    private double xSpeed;  // speed in X direction

    private double ySpeed;  // speed in Y direction

    /**
     * initial bird's state 
     */
    public Bird() {
        color = Color.BLUE;
        xAxis = 0.05;
        yAxis = 0.5;
        alive = true;
        xSpeed = 0.01;
        ySpeed = 0.01;
    }

    /**
     * if bird is jumping, Y axis adds
     */
    public void jump() {
        yAxis += ySpeed * 3;
    }

    /**
     * When gaming, bird is moving.
     * X axis of bird should not be changed. 
     * Instead, X axises of walls should be changed.
     * See {@link Utils#getWalls()} 
     */
    public void move() {
        if(xAxis < 0.5)     
            xAxis += xSpeed;    
        yAxis -= ySpeed;
    }

    public Color getColor() {
        return color;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    /**
     * judge bird is alive or not 
     */
    public boolean isAlive() {
        return alive;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * set bird's life state
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * draw bird in the screen
     */
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.point(xAxis, yAxis);
    }
}
