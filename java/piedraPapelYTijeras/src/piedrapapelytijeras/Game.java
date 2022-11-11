package piedrapapelytijeras;


public class Game {

        public static void calculateWinner(Player player, Npc npc) {

                final int[][] winTable = {
                        {1, 2, 0},
                        {0, 1, 2},
                        {2, 0, 1}
                };

                switch (winTable[player.getAction()][npc.getAction()]) {
                        case 0 -> {
                                player.addWin();
                                System.out.printf("""
                                                %sThe player has won this round...
                                                PLAYER [%d][%d] NPC
                                                %s
                                                """,
                                        Colour.PURPLE, player.getLocalScore(), npc.getLocalScore(),
                                        Colour.RESET);

                        }
                        case 1 -> System.out.printf("""
                                        %sDraw...
                                        PLAYER [%d][%d] NPC
                                        %s""",
                                Colour.PURPLE, player.getLocalScore(), npc.getLocalScore(), Colour.RESET);
                        case 2 -> {
                                npc.addWin();
                                System.out.printf("""
                                                %sThe computer has won this round...
                                                PLAYER [%d][%d] NPC
                                                %s""",
                                        Colour.RED, player.getLocalScore(), npc.getLocalScore(), Colour.RESET);

                        }
                }
        }

        public static void showElection(Player player, Npc npc){
                switch (player.getAction()){
                        case 0 -> System.out.println(player.getName() + " escoge piedra");
                        case 1 -> System.out.println(player.getName() + " escoge paper");
                        case 2 -> System.out.println(player.getName() + " escoge tijera");
                }
                switch (npc.getAction()){
                        case 1 -> System.out.println(npc.getName() + " escoge paper");
                        case 2 -> System.out.println(npc.getName() + " escoge tijera");
                        case 0 -> System.out.println(npc.getName() + " escoge piedra");
                }
        }
}