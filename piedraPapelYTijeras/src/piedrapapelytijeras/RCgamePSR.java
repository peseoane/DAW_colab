package piedrapapelytijeras;

import java.util.Scanner;

class gameRule {

    /**
     * Returns a byte from the matrix, paper
     * @param playerAction loads the byte for the row value [0:paper,1:scissors,2:rock]
     * @param pcAction loads the byte for the column value
     *      *                 [0:paper,1:scissors,2:rock]
     * @return a byte with a byte, 0: wins the PC, 1: DRAW and 2: wins the player
     */
    public byte winner(byte playerAction, byte pcAction) {

        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[playerAction][pcAction];
    }

    /**
     * This generates a random true or false to enable the cheat mode for the PC, but only if the player is winning,
     * also this condicition isn't always true and it's random generated (1/2 chance).
     * @param playerScore Byte that reads the player score.
     * @param pcScore Byte that reads the pc score.
     * @return Return the status of the cheat (boolean)
     */
    public boolean godMode(byte playerScore, byte pcScore) {

        if (playerScore > pcScore)
            return new java.util.Random().nextBoolean();
        else
            return false;

    }

    private byte pcAction(byte playerAction, boolean godMode) {

        byte pcAction = 0;

        if (godMode) {
            switch (playerAction) {
                case 0, 2 -> pcAction = 1;
                case 1 -> pcAction = 2;
            }
        }
        else pcAction = (byte) (new java.util.Random().nextInt(3));
        return  pcAction;
    }
}

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
};

public class RCgamePSR {
        public static void main(String[] args) {
        }
    }
