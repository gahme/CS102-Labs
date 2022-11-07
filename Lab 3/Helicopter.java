public class Helicopter extends EnemyVehicle{
    private int speed = BASE_SPEED;

    public Helicopter(int minX, int maxX, int y){
        super(minX, maxX, y);
    }

    @Override
    public void move(){
        coordinates.y -= speed;
        speed ++;
    }

    public String toString(){
        String result = "";
        result += "H";
        result += " - (" + coordinates.getX() + ", " + coordinates.getY() + ")";
        return result;
    }

    public String getType(){
        return "Helicopter";
    }
    
}
