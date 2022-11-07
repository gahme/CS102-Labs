import java.util.Scanner;

public class GameTester {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter difficulty level (1-3):");
        String difficultyStr = in.nextLine();
        int difficulty = Integer.parseInt(difficultyStr);


        Game currentGame = new Game(difficulty);
        GamePlotter currentGamePlotter = new GamePlotter(currentGame);
        while (currentGame.vehiclesPassed < currentGame.MAX_NO_OF_PASSING_ENEMIES){
            currentGamePlotter.plot();
            currentGame.play();
        }

        System.out.println("Final score of player: " + currentGame.currentPlayer.getScore());

        in.close();
    }
    
}
