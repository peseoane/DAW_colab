package piedrapapelytijeras;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Filosofía clásica... empezamos abriendo un mainLoop que controle el juego
        // vamos a intentar contener los posibles errores de manera localizada
        boolean loopGame = true;
        String exitGame;
        // Tanto el jugador como el PC son dos clases, las instanciamos y las iremos
        // manipulando,
        // vamos a evitar trabajar con ellas directamente
        // TODO: ¿Juntar Player y NPC en una superclase? es posible...

        Player player = new Player();
        player.playerName();
        System.out.printf("Hola %s\n", player.getName());
        Npc npc = new Npc();
        Scanner input = new Scanner(System.in, Colour.ENCODING);

        while (loopGame) {
            // Como el NPC depende del jugador, por el modo tramposo, primero se le pide al
            // jugador la jugada
            player.playerChoice();
            // El NPC tiene maneras de comprobar si pierde, lee del objeto player cosas como
            // si él tiene más victorias
            // por eso es importante respetar este orden
            npc.calculateAction(player);
            // Aquí ya el NPC ha decidido si ser tramposo o no, y calculado la jugada
            // invencible o aleatoria, dado que
            // como tiene acceso a player, sabe su jugada,
            // por tanto, en el siguiente método mandamos ambas jugadas y nos devuelve
            // ganador actualizando
            // sus atributos respetivamente
            Game.calculateWinner(player, npc);
            Game.showElection(player, npc);
            Game.showStats(player,npc);
            Game.showCheatStatus(npc);

            // System.out.println("Press any key to continue...");
            // input.nextLine();

            // Cada tres partidas, preguntar si desea seguir nada en especial
            if (player.getLocalScore() >= 3 || npc.getLocalScore() >= 3) {
                System.out.println("Play again? N to exit, press any key to continue");
                exitGame = input.nextLine();
                if (exitGame.equalsIgnoreCase("n")) {
                    System.err.println("\n### HALT ###");
                    loopGame = false;
                    input.close();
                } else {
                    // ¡Si se quiere continuar, reiniciamos la partida local, pero el contador global
                    // sigue rolando!
                    System.out.println("\n### NEW GANE ###\n");
                    if (player.getLocalScore() >= 3) {
                        player.addGlobalScore();
                    } else {
                        npc.addGlobalScore();
                    }
                    // No lo voy a reiniciar el addGlobalScore por modularidad, nada debe depender
                    // de todo en exceso
                    player.setLocalScore(0);
                    npc.setLocalScore(0);
                }
            }
        }
    }
}
