package piedrapapelytijeras;

import javax.print.DocFlavor;
import java.util.Locale;
import java.util.Scanner;

class exitGame {
    private boolean loopGame = true;
    private byte scorePlayer;
    private byte scorePc;
    private String exitGame;

    Scanner input = new Scanner(System.in);

    public boolean playAgain() {
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
        return loopGame;
    }
}

public class RCgamePSR {
    public static void main(String[] args) {

    }
}
