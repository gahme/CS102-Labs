public class Tank extends EnemyVehicle{

    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
    }

    @Override
    public void takeDamage(double damage){
        // Take 50%(?) less damage from attacks
        health -= damage * 0.5;
    }

    @Override
    public void move() {
        coordinates.y -= BASE_SPEED;
    }

    public String toString(){
        String result = "";
        result += "T";
        result += " - (" + coordinates.getX() + ", " + coordinates.getY() + ")";
        return result;
    }

    public String getType(){
        return "Tank";
    }
}
