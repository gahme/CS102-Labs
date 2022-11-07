import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    final int STARTING_DISTANCE = 10;
    final int MAX_NO_OF_PASSING_ENEMIES = 10;
    private int difficulty;
    public  Player currentPlayer;
    private ArrayList<EnemyVehicle> enemies = new ArrayList<EnemyVehicle>();
    int vehiclesPassed = 0;


    public Game(int difficulty){
        this.difficulty = difficulty;
        for (int i=0; i<difficultySelector(difficulty); i++){
            enemies.add(getNewRandomVehicle());
        }
        currentPlayer = new Player();
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public void play(){
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter x and y coordinates: ");
        int[] inputs = new int[2];
        for (int i=0; i<2; i++){
            inputs[i] = in.nextInt();
        }

        // Print game state
        printGameState();

        // Attack enemies
        currentPlayer.attack(inputs[0], inputs[1], enemies);

        // Check if enemies destroyed
        for (int i=0; i<enemies.size(); i++){
            if (enemies.get(i).isDestroyed()){
                enemies.set(i, getNewRandomVehicle());
                currentPlayer.increaseScore(1);
            }
        }

        // Move enemies
        for (int i=0; i<enemies.size(); i++){
            enemies.get(i).move();
            if (enemies.get(i).getDistanceToBorder() <= 0){
                vehiclesPassed ++;
                enemies.set(i, getNewRandomVehicle());
            }
        }
    }

    public ArrayList<EnemyVehicle> getEnemies(){
        return enemies;
    }

    public EnemyVehicle getNewRandomVehicle(){
        Random rnd = new Random();
        int choice = rnd.nextInt(1, 3); // 1 or 2

        if (choice == 1){
            return new Helicopter(0, xCoordinateSelector(difficulty), STARTING_DISTANCE);
        }
        else{
            return new Tank(0, xCoordinateSelector(difficulty), STARTING_DISTANCE);
        }
    }

    private int difficultySelector(int x){
        if (x == 1){
            return 2;
        }
        else if (x == 2){
            return 4;
        }
        else if (x == 3){
            return 6;
        }
        else return 0;
    }

    private int xCoordinateSelector(int x){
        if (x == 1){
            return 5;
        }
        else if (x == 2){
            return 10;
        }
        else if (x == 3){
            return 15;
        }
        else return 0;
    }

    private int[] vehicleCounter(ArrayList<EnemyVehicle> enemies){
        int[] vehicleCounter = new int[2];
        for (EnemyVehicle enemy: enemies){
            if (enemy.getType().equals("Helicopter")){
                vehicleCounter[0] ++; //Store count of helicopters in vehicleCounter[0]
            }
            else if (enemy.getType().equals("Tank")){
                vehicleCounter[1] ++; //Store count of tanks in vehicleCounter[0]
            }
        }
        return vehicleCounter;
    }

    public void printGameState(){
        System.out.println("Vehicles passed: " + vehiclesPassed);
        System.out.println("Number of Helicopters: " + vehicleCounter(enemies)[0]);
        System.out.println("Number of Tanks: " + vehicleCounter(enemies)[0]);
    }
    
}
