import java.util.Random;
import java.awt.*;

abstract class EnemyVehicle implements Movable, Destructible{
    // private int y;
    // private int x;
    private int difficulty;
    // public variables
    Point coordinates = new Point();
    final int BASE_SPEED = 3;
    double health;

    // Constructor
    public EnemyVehicle(int minX, int maxX, int y){
        Random rand = new Random();
        coordinates.x = rand.nextInt(maxX - minX) + minX;
        coordinates.y = y;
    }

    public int getDistanceToBorder(){
        // Assuming border is y = 0;
        return coordinates.y;
    }

    abstract String getType();

    // > Interface methods <
    // Destructible 
    public boolean isDestroyed(){
        return health < 0;
    }

    public void takeDamage(double damage){
        health -= damage;
    }

    // Difficulty 
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public int getDifficulty(){ 
        return difficulty;
    }

    // Movable 
    public void Move(){
        coordinates.y -= BASE_SPEED;
    }

    public Point getLocation(){
        return coordinates;
    }
}
