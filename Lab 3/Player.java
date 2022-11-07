import java.awt.*;
import java.util.ArrayList;

public class Player {
    private final double BOMB_RADIUS  = 2.0;
    private final double DAMAGE = 50.0;
    private int playerScore = 0;

    public Player(){
    }

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){
        for (EnemyVehicle enemy: enemies){
            if (checkArea(x, y, BOMB_RADIUS, enemy.getLocation())){
                enemy.takeDamage(DAMAGE);
            }
        }
    }

    // Helper methods
    public boolean checkArea(int x, int y, double radius, Point coordinates){
        // Returns true if given coordinates are inside given circle
        return Math.sqrt(Math.pow((x-coordinates.x), 2) + Math.pow((y-coordinates.y), 2)) <= radius;
    }

    public void increaseScore(int n){
        playerScore += n;
    }

    public int getScore(){
        return playerScore;
    }
}
