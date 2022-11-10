package piedrapapelytijeras;

public class Game {
    
    public void returnWinner(Player player, Npc npc) {

        final int[][] winTable = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        switch (whoWin(playerAction, pcAction)) {
                    case 0 -> {
                        ;
                        System.out.printf("""
                                        %sThe player has won this round...
                                        PLAYER [%d][%d]
                                        %s
                                        """,
                                ANSI_GREEN, scorePlayer, scorePc, ANSI_RESET);
                    }
                    case 1 -> System.out.printf("""
                                    %sDraw...
                                    PLAYER [%d][%d]
                                    %s""",
                            ANSI_PURPLE, scorePlayer, scorePc, ANSI_RESET);
                    case 2 -> {
                        scorePc++;
                        System.out.printf("""
                                        %sThe computer has won this round...
                                        PLAYER [%d][%d]
                                        %s""",
                                ANSI_RED, scorePlayer, scorePc, ANSI_RESET);
                    }
    }   
}
