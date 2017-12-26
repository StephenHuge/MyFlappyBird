package my.bird.game;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * this class represents walls for this game.
 * a Wall instance means wall above & wall below,
 * so there are 1 X axis and 2 Y axises in this class. 
 *  
 * @author HJS
 *
 * @date 2017å¹?10æœ?8æ—?
 */
public class Wall {

    private Color color;        // color of the wall

    private double xAxis;        // X axis of the wall

    private double gap;          // distance between the wall above and the one below 

    private double aboveYAxis;   // Y axis of the wall's low side above

    private double belowYAxis;   // Y axis of the wall's high side below

    /**
     * initial the wall
     * use random API to get random height for the wall below
     */
    public Wall(double xAxis) {
        double random = StdRandom.uniform(0.3, 0.6);      
        color = Color.MAGENTA;
        this.xAxis = xAxis;
        gap = 0.3;                  
        belowYAxis = random;        // height of wall below is a random number
        aboveYAxis = random + gap;  // height of wall above is a random number + gap
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double d) {
        this.xAxis = d;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public double getAboveYAxis() {
        return aboveYAxis;
    }

    public void setAboveYAxis(double aboveYAxis) {
        this.aboveYAxis = aboveYAxis;
    }

    public double getBelowYAxis() {
        return belowYAxis;
    }

    public void setBelowYAxis(double belowYAxis) {
        this.belowYAxis = belowYAxis;
    }
    /**
     * draw the wall
     */
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.line(xAxis, 1.0, xAxis, aboveYAxis);   // wall above
        StdDraw.line(xAxis, 0.0, xAxis, belowYAxis);   // wall below
    }

}
