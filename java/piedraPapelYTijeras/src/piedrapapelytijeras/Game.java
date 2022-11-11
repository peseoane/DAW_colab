package piedrapapelytijeras;

public class Game {

    /**
     * @param player recibe el jugador tal cual
     * @param npc    recibe el NPC pero debe de tener ya calculadas las trampas, esto lo hará en su clase por otros métodos (godMode)
     */
    public static void calculateWinner(Player player, Npc npc) {

        // Esta tabla, al acceder jugador=X npc=Y nos dice con 0,1 o 2 si pierde el jugador, empata o pierde. 
        final int[][] winTable = {{1, 2, 0}, {0, 1, 2}, {2, 0, 1}};

        switch (winTable[player.getAction()][npc.getAction()]) {
            case 0 -> {
                player.addWin();
                System.out.printf("%sThe player has won this round...\n", Colour.GREEN);
            }
            case 1 -> System.out.printf("%sDraw...\n", Colour.PURPLE);
            case 2 -> {
                npc.addWin();
                System.out.printf("%sThe computer has won this round...\n", Colour.RED);
            }
        }
    }

    public static void showStats(Player player, Npc npc){
        // Las estadísticas como son siempre comunes, no tienen mucho sentido mostrarlas siempre en cada switch, las muevo fuera.
        System.out.printf("""
                %s This game: %s [%d][%d] %s
                %s All games: %s [%d][%d] %s
                %s
                """, Colour.PURPLE, player.getName(), player.getLocalScore(), npc.getLocalScore(), npc.getName(), Colour.GREEN, player.getName(), player.getGlobalScore(), npc.getGlobalScore(), npc.getName(), Colour.RESET);
    }

    /**
     * Símplemente, nos traduce la acción 0 1 o 2 por piedra, papel o tijeras.
     */
    public static void showElection(Player player, Npc npc) {

        switch (player.getAction()) {
            case 0 -> System.out.println(player.getName() + " choose paper");
            case 1 -> System.out.println(player.getName() + " choose scissors");
            case 2 -> System.out.println(player.getName() + " choose rocks");
        }
        switch (npc.getAction()) {
            case 1 -> System.out.println(npc.getName() + " choose paper");
            case 2 -> System.out.println(npc.getName() + " choose scissors");
            case 0 -> System.out.println(npc.getName() + " choose rocks");
        }
    }
    public static void showCheatStatus(Npc npc){
        System.out.println(Colour.RED + "Cheat status: " + npc.isGodMode() + Colour.RESET);
    }
}