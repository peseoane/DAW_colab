package piedrapapelytijeras;

public class Main {

    /**
     * El juego se ejecuta en un mainLoop clásico, vamos a usar la estructura expuesta en el
     * UML, es decir, hay una superclase de normas, y dos clases de jugador, y NPC, luego,
     * pasaremos estos objetos creados a la clase Game, que decidirá el transcurso de la partida.
     *
     * @param args usados para depurar, -1 lanza terminal externa, y logea partidas para analizar estadísticas.
     */
    public static void main(String[] args) {

        int logArg = 0;
        if (args.length > 0) {
            try {
                logArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }

        boolean loopGame = true;
        String exitGame;

        Player player = new Player();
        Npc npc = new Npc();

        System.out.println(TerminalAux.GREEN + TerminalAux.HI + player.getName() + TerminalAux.RESET);

        Log.createLog();

        while (loopGame) {

            if (logArg == 1) {
                player.setAction(new java.util.Random().nextInt(3));
            } else {
                player.playerChoice();
            }

            npc.calculateAction(player);

            /*
            Es importante respetar este orden, dado que, el NPC DEPENDE de la jugada del jugador y sus victorias
            para saber si hacer trampa o no, así que SIEMPRE vamos a hacer primero al jugador.
             */
            Game.calculateWinner(player, npc);
            Game.showElection(player, npc);
            Game.showStats(player, npc);
            Game.showCheatStatus(npc);
            /*
             La lógica del juego es simple, una vez tenemos las jugadas calculadas, si alguno de los dos
             jugadores ha llegado a tres victorias, se pregunta si se desea continuar con la partida, en caso
             positivo, se reinician los contadores de partida local, y se añade una victoria global al ganador.
             */
            if (player.getLocalScore() >= 3 || npc.getLocalScore() >= 3) {
                System.out.println(TerminalAux.ASK_NEXT_ROUND);
                if (logArg != 1) {
                    exitGame = CommonRules.input.nextLine();
                } else {
                    exitGame = "x";
                }

                if (exitGame.equalsIgnoreCase(TerminalAux.KEY_TO_EXIT)) {
                    System.err.println(TerminalAux.EXIT_GAME);
                    loopGame = false;
                    CommonRules.input.close();

                } else {
                    System.out.println(TerminalAux.NEW_GAME);
                    if (player.getLocalScore() >= 3) {
                        player.addGlobalScore();
                    } else {
                        npc.addGlobalScore();
                    }
                    /*
                    Reiniciar los contadores de la partida es algo común a ambos, lo hacemos fuera.
                     */
                    player.setLocalScore(0);
                    npc.setLocalScore(0);
                    Log.registerLog(player, npc);
                }
            }
        }
    }
}
