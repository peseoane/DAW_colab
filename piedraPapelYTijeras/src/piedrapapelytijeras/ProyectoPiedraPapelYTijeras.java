
package piedrapapelytijeras;

import java.util.Scanner;

/**
 * Piedra, papel y tijera.
 * 
 * @author a22pedrovsp
 * @author a20amelych
 */

public class ProyectoPiedraPapelYTijeras {

    /**
     */

    static byte whoWin(int jugador, int npc) {

        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[jugador][npc];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        final String encoding = "ISO-8859-1";

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_PURPLE = "\u001B[35m";

        // Menú principal

        boolean loopGame = true;
        byte scorePlayer = 0;
        byte scorePc = 0;
        byte playerAction;
        String salirdeljuego;
        String mainDialog = """
                ### PAPER SCISSORS ROCK! ###
                It's your turn, what do you choose?
                0 - Rock.
                1 - Paper.
                2 - Scissors.
                """;

        Scanner input = new Scanner(System.in, encoding);

        while (loopGame) {
            
            System.out.printf("%s%s%s\n", ANSI_PURPLE, mainDialog, ANSI_RESET);

            try {
                playerAction = input.nextByte();
                int pcAction = new java.util.Random().nextInt(3);
                System.out.printf("\nThe computer has chosen: %d\n", pcAction);

                switch (whoWin(playerAction, pcAction)) {
                    case 0:
                        scorePlayer++;
                        System.out.printf("""
                                %sThe player has won this round...
                                PLAYER [%d][%d]\n%s
                                """,
                                ANSI_GREEN, scorePlayer, scorePc, ANSI_RESET);
                        break;
                    case 1:
                        System.out.printf("""
                                %sDraw...
                                PLAYER [%d][%d]\n
                                %s""",
                                ANSI_PURPLE, scorePlayer, scorePc, ANSI_RESET);
                        break;
                    case 2:
                        scorePc++;
                        System.out.printf("""
                                %sThe computer has won this round...
                                PLAYER [%d][%d]\n
                                %s""",
                                ANSI_RED, scorePlayer, scorePc, ANSI_RESET);
                        break;

                }

                if (scorePlayer >= 3 || scorePc >= 3) {
                    System.out.println("Play again?");
                    input.nextLine(); // Limpieza de bufer.
                    salirdeljuego = input.nextLine();
                    if (salirdeljuego.toLowerCase().equals("n")) {
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
                input.nextLine(); // Limpieza de bufer.
                java.awt.Toolkit.getDefaultToolkit().beep(); // Alert sound... just from system inherit...
            }
        }
    }
}
