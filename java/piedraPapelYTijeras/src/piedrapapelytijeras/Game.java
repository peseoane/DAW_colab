package piedrapapelytijeras;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import piedrapapelytijeras.Player;
import piedrapapelytijeras.Pc;

public class Game {
    // Atributos
    private int id;
    private byte player1;
    private byte player2;
    private byte points;
    private byte wins;

    // Constructor

    public Game(int id, byte player1, byte player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.points = 0;
        this.wins = 0;
    }

    // Métodos

    public void menu() {
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

    public void stats(byte player1, byte player2) {
        System.out.println("----------------");
        System.out.println(player1);
        System.out.println("Ha ganado: " + wins);
        System.out.println("Lleva " + points + " puntos");
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(player2);
        System.out.println("Ha ganado: " + wins);
        System.out.println("Lleva " + points + " puntos");
        System.out.println("----------------");
    }

    public byte getWinner(Player.playerAction, Pc.pcAction) {
        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[playerAction][pcAction];
    }

    public byte addPoints() {
        switch (whoWin(Player.playerAction, Pc.pcAction)) {
            case 0 -> {
                Player.scorePlayer++;
                System.out.printf("""
                        %sThe player has won this round...
                        PLAYER [%d][%d]
                        %s
                        """,
                        ANSI_GREEN, Player.scorePlayer, Player.scorePc, ANSI_RESET);
            }
            case 1 -> System.out.printf("""
                    %sDraw...
                    PLAYER [%d][%d]
                    %s""",
                    ANSI_PURPLE, Player.scorePlayer, Player.scorePc, ANSI_RESET);
            case 2 -> {
                Player.scorePc++;
                System.out.printf("""
                        %sThe computer has won this round...
                        PLAYER [%d][%d]
                        %s""",
                        ANSI_RED, Player.scorePlayer, Player.scorePc, ANSI_RESET);
            }
        }
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

}
