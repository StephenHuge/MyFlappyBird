package my.bird.hello;

import edu.princeton.cs.algs4.StdDraw;

public class BirdTest1 {
    public static void main(String[] args) {
        drawBird();
    }
    
    public static void drawBird() {
        float xAxis = 0.05f;
        float yAxis = 1.0f;
        
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(xAxis, yAxis);
        for(;;) {
            xAxis += 0.01;
            yAxis -= 0.01;
            StdDraw.point(xAxis, yAxis);
            StdDraw.pause(100);
            if(xAxis >= 1.0)    xAxis = 0;
            if(yAxis <= 0)      yAxis = 1;
        }
    }
}
