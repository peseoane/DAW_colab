
import java.util.Scanner;

public class GameT {
    // Atributos
    private boolean loopGame;
    private boolean godMode;
    private byte scorePlayer;
    private byte scorePc;
    private byte playerAction;
    private byte pcAction;
    private String exitGame;

    Scanner input = new Scanner(System.in);


    // Constructor

    public GameT(boolean loopGame, boolean godMode, byte playerAction, String exitGame) {
        this.loopGame = loopGame;
        this.godMode = godMode;
        this.scorePlayer = 0;
        this.scorePc = 0;
        this.playerAction = playerAction;
        this.pcAction = 0;
        this.exitGame = exitGame;
    }

    // Métodos

    public void menu(){
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

    public byte winner(byte playerAction, byte pcAction) {
        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[playerAction][pcAction];
    }

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
        } else
            pcAction = (byte) (new java.util.Random().nextInt(3));
        return pcAction;
    }

    public void playAgain() {
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
