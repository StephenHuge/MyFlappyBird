package my.bird.flappy;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;


public class Bird {
    private Color color;    // color of this bird
    
    private double xAxis;    // X axis of this bird
    
    private double yAxis;    // Y axis of this bird
    
    private boolean alive;  // life state of this bird
    
    private double xSpeed;  // speed in X direction
    
    private double ySpeed;  // speed in Y direction
    public Bird() {
        color = Color.BLUE;
        xAxis = 0.05;
        yAxis = 0.5;
        alive = true;
        xSpeed = 0.01;
        ySpeed = 0.01;
    }
    
    public void jump() {
        yAxis += ySpeed * 3;
    }
    
    public void move() {
        if(xAxis < 0.5)     // X axis should not be changed, X axises of walls should be change.
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

    public boolean isAlive() {
        return alive;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.point(xAxis, yAxis);
    }
}
