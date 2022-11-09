
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class GameT {
    // Atributos
    private int id;
    private byte player1;
    private byte player2;
    private byte points;
    private byte wins;

    // Constructor
    
    public GameT(int id, byte player1, byte player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.points = 0;
        this.wins = 0;
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

    public void stats() {
        System.out.println("----------------");
        System.out.println();
        System.out.println("Ha ganado: " + wins);
        System.out.println("Lleva " + points + " puntos");
        System.out.println("----------------");
    }

    public byte winner(playerT, pcAction) {
        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[playerAction][pcAction];
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
        private byte scorePlayer;
        private byte scorePc;
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
