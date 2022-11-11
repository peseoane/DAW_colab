package piedrapapelytijeras;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean loopGame = true;

        System.out.println(Colour.DIALOG);
                        
        // Creamos el objeto del jugador
        Player player = new Player();  
        player.playerName();        
        System.out.printf("Hola %s", player.getName());
        Npc npc = new Npc();


        String exitGame;
        while (loopGame) ;

            player.playerChoice(); 
            Game.returnWinner(player, npc);

            if (player.getLocalScore() >= 3 || npc.getLocalScore() >= 3) {
                System.out.println("Play again? Y/N");
                Scanner input = new Scanner(System.in,Colour.ENCODING);
                exitGame = input.nextLine();

                if (exitGame.equalsIgnoreCase("n")) {
                    System.err.println("\n### HALT ###");
                    loopGame = false;
                    input.close();

                } else {
                    System.out.println("\n### NEW GANE ###\n");
                    if (player.getLocalScore() >= 3){
                        player.addGlobalScore();
                    }
                    else {npc.addGlobalScore();}
                    player.setLocalScore(0);
                    npc.setLocalScore(0);
                    loopGame = false;
                }
            }


        }
    }

}
