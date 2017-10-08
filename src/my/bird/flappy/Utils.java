package my.bird.flappy;

/**
 * a util class 
 * 
 * @author HJS
 *
 * @date 2017年10月8日
 */
public class Utils {
    
    private static Wall[] walls;    // in one frame, there are several walls 
    
    private static int pivot = 0;   // a pivot for walls
    
    private static double wallSpeed = 0.01; // wall's retreating speed 
    
    private Utils() { }   // this class should not be initialized
    
    /**
     * clean game's state to original state 
     */
    public static void clear() {
        pivot = 0;
        walls = null;
        wallSpeed = 0.01;
    }
    
    /**
     * as walls should be changing, this method generate new walls still   
     */
    public static Wall[] getWalls() {
        if(walls == null) {
            walls = new Wall[3];
            for(int i = 0; i < walls.length; i++) {
                walls[i] = new Wall(0.3333 * (i + 1));
            }
        }
        for(Wall w: walls) {
            if(w.getxAxis() >= 0) { // if wall is in the frame, then move backward 
                w.setxAxis(w.getxAxis() - wallSpeed);
            }
            else {  // if wall is not in the frame, generate a new wall to replace old wall
                walls[pivot] = new Wall(1.0);
                if(pivot < walls.length - 1)    pivot++;
                else                            pivot = 0;
            }
        }
        return walls;
    }
}
