package piedrapapelytijeras;

import Player;
import Npc;
import Game;
import Colour;

public class Main {

    public static void main(String[] args) {

        boolean loopGame = true;

        System.out.println(Colour.mainDialog);
                        
        // Creamos el objeto del jugador
        Player player = new Player();  
        player.playerName();        
        System.out.printf("Hola %s", player.name);
        Npc npc = new Npc();

        while (loopGame) {

            player.playerChoice(); 
            Game.returnWinner(player, npc);
        }
    }

}
