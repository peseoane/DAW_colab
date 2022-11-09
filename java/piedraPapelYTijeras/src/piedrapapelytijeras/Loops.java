package piedrapapelytijeras;

import java.util.Scanner;

class Loops {
    private byte scorePlayer;
    private byte scorePc;

    Scanner input = new Scanner(System.in);

    public boolean playAgain() {
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
        return loopGame;
    }
}

class menu {
    final String encoding = "ISO-8859-1";
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String mainDialog = """
            ### ROCK PAPER SCISSORS! ###
            It's your turn, what do you choose?
            0 - Rock.
            1 - Paper.
            2 - Scissors.
            """;
}