package piedrapapelytijeras;
import java.util.Scanner;

public class Player {
    // Atributos
    private String name;
    public static int playerAction;
    private byte scorePlayer;
    private byte scorePc;

    // Constructor

    public Player(String name) {
        this.name = name;
    }
    
    // Métodos
    
    public int playerChoice() {
        Scanner input = new Scanner(System.in);
        playerAction = input.nextByte();
        input.nextByte();
        return playerAction;
    }

    public void keepPlaying() {
        Scanner input = new Scanner(System.in);
        boolean loopGame = true;
        final String exitGame;
        if (scorePlayer >= 3 || scorePc >= 3) {
            System.out.println("Play again? Y/N");
            exitGame = input.nextLine();
            if (exitGame.equalsIgnoreCase("n")) {
                System.err.println("\n### HALT ###");
                loopGame = false;
                input.close();
            } else {
                System.out.println("\n### NEW GAME ###\n");
                scorePlayer = 0;
                scorePc = 0;
            }
        }
    }

}
