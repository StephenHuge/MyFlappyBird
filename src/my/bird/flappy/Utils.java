package my.bird.flappy;

public class Utils {
    
    private static Wall[] walls;
    
    private static int pivot = 0;
    
    private static double wallSpeed = 0.01;
    private Utils() { }   // this class should not be initialized
    
    public static void clear() {
        pivot = 0;
        walls = null;
        wallSpeed = 0.01;
    }
    
    public static Wall[] getWalls() {
        if(walls == null) {
            walls = new Wall[3];
            for(int i = 0; i < walls.length; i++) {
                walls[i] = new Wall(0.3333 * (i + 1));
            }
        }
        for(Wall w: walls) {
            if(w.getxAxis() >= 0) {
                w.setxAxis(w.getxAxis() - wallSpeed);
            }
            else {
                walls[pivot] = new Wall(1.0);
                if(pivot < walls.length - 1)    pivot++;
                else                            pivot = 0;
            }
        }
        
        
        return walls;
    }
    
    public static int getPivot() {
        return pivot;
    }
    
}
