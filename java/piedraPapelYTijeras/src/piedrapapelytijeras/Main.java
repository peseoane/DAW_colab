package piedrapapelytijeras;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {

        System.out.println("""
                        ##### PAPER, SCISSORS, ROCK! #####
                        """);
                        

        // Creamos el objeto del jugador
        Player player = new Player();
        player.playerName();        
        System.out.printf("Hola %s", player.name);
        player.playerChoice();
        Npc npc = new Npc();
        Game game = new Game(player,npc);     

    }

}
