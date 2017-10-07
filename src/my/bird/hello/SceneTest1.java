package my.bird.hello;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class SceneTest1 {
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        drawWall();
    }
    
    public static void drawWall() {
        float xAxis = 0.05f;
        float xGap = 0.3f;
        float yGap = 0.3f;
        double random;
        
        for(int i = 0; i < 4; i++) {
            random = StdRandom.uniform(0.3, 0.7);
            StdDraw.line(xAxis, 1.0, xAxis, random + yGap);   // up wall
            StdDraw.line(xAxis, 0.0, xAxis, random);         // down wall
            
            xAxis += xGap;
        }
    }
    
}
