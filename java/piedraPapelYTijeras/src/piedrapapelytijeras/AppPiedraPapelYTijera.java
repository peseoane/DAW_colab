package piedrapapelytijeras;

import java.util.Scanner;
import piedrapapelytijeras.Game;
import piedrapapelytijeras.Loops;

/**
 * PAPER SCISSORS ROCK!
 *
 * @author a22pedrovsp
 * @author a20amelych
 * @version 0.3
 */

public class AppPiedraPapelYTijera {
    public static void main(String[] args) {
        
        boolean loopGame = true;
        boolean godMode; // It will load sometimes...
        byte scorePlayer = 0;
        byte scorePc = 0;
        byte playerAction;
        byte pcAction = 0;
        String exitGame;

        Scanner input = new Scanner(System.in, "ISO-8859-1");

        /*
         * Due to be a simple CLI game, we just enter on the main point with a loop,
         * unless when a game it's over the player can choose to halt the game, a
         * boolean will switch (loop-game) to false.
         */
        while (loopGame) {

            // This ANSI it's just for scape chars... works in Powershell and Bash. Maybe
            // not in cmd but it's deprecated who cares.
            System.out.printf("%s%s%s\n", ANSI_PURPLE, mainDialog, ANSI_RESET);

            // @TODO Improve this exception block... just catches everything...
            try {
                playerAction = input.nextByte();
                input.nextLine();
                godMode = new java.util.Random().nextBoolean();

                // Sometimes, if the computer is loosing, and the random boolean it's true, it will cheat on you!
                if (godMode && (scorePlayer > scorePc)) {
                    /*
                     * We assign the pcAction to always wins to the player!
                     */
                    switch (playerAction) {
                        case 0, 2 ->
                                pcAction = 1; // TIL this... for my taste is hard to read, but I don't like JetBrains warnings...
                        case 1 -> pcAction = 2;

                    }

                    System.out.printf("%s\nCHEAT STATUS: %b%s\n", ANSI_RED, true, ANSI_RESET); // intelliJ hates not using constant when possible...
                } else {
                    pcAction = (byte) (new java.util.Random().nextInt(3));
                    System.out.printf("%s\nCHEAT STATUS: %b%s\n", ANSI_GREEN, false, ANSI_RESET);
                }
                System.out.printf("\nThe computer has chosen: %d\n", pcAction);
                /*
                 * We call a method that returns a 0,1 or 2 (Player wins, draw or computer
                 * wins).
                 * If
                 */

                switch (whoWin(playerAction, pcAction)) {
                    case 0 -> {
                        scorePlayer++;
                        System.out.printf("""
                                        %sThe player has won this round...
                                        PLAYER [%d][%d]
                                        %s
                                        """,
                                ANSI_GREEN, scorePlayer, scorePc, ANSI_RESET);
                    }
                    case 1 -> System.out.printf("""
                                    %sDraw...
                                    PLAYER [%d][%d]
                                    %s""",
                            ANSI_PURPLE, scorePlayer, scorePc, ANSI_RESET);
                    case 2 -> {
                        scorePc++;
                        System.out.printf("""
                                        %sThe computer has won this round...
                                        PLAYER [%d][%d]
                                        %s""",
                                ANSI_RED, scorePlayer, scorePc, ANSI_RESET);
                    }
                }

                if (scorePlayer >= 3 || scorePc >= 3) {
                    System.out.println("Play again? Y/N");
                    exitGame = input.nextLine();
                    if (exitGame.equalsIgnoreCase("n")) {
                        System.err.println("\n### HALT ###");
                        loopGame = false;
                        input.close();
                    } else {
                        System.out.println("\n### NEW GANE ###\n");
                        scorePlayer = 0;
                        scorePc = 0;
                    }
                }

            } catch (Exception e) {
                System.err.printf("%sOnly numbers from 0 to 2 are allowed.%s", ANSI_RED, ANSI_RESET);
                input.nextLine(); // Cleaning input buffer
                java.awt.Toolkit.getDefaultToolkit().beep(); // Alert sound... just from system inherit...
            }
        }
    }
}