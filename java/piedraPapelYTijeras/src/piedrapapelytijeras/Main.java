package piedrapapelytijeras;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean loopGame = true;
        String exitGame;

        // Creamos el objeto del jugador
        Player player = new Player();
        player.playerName();
        System.out.printf("Hola %s\n", player.getName());
        Npc npc = new Npc();

        while (loopGame) {

            player.playerChoice();
            npc.calculateAction(player);
            Game.returnWinner(player, npc);
            Game.showElection(player, npc);
            System.out.println(Colour.RED + "Cheat status: " + npc.isGodMode() + Colour.RESET);

            if (player.getLocalScore() >= 3 || npc.getLocalScore() >= 3) {
                System.out.println("Play again? N to exit, press any key to continue");
                Scanner input = new Scanner(System.in, Colour.ENCODING);
                exitGame = input.nextLine();

                if (exitGame.equalsIgnoreCase("n")) {
                    System.err.println("\n### HALT ###");
                    loopGame = false;
                    input.close();

                } else {
                    System.out.println("\n### NEW GANE ###\n");
                    if (player.getLocalScore() >= 3) {
                        player.addGlobalScore();
                    } else {
                        npc.addGlobalScore();
                    }
                    player.setLocalScore(0);
                    npc.setLocalScore(0);
                }
            }


        }
    }
}
