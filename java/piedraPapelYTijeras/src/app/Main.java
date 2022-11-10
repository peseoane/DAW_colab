package app;

import app.Game;
import app.Npc;
import app.Player;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("""
                        ##### PAPER, SCISSORS, ROCK! #####
                        """);
                        

        Player amely = new Player("amely", 0, 0, 0);
        
        System.out.println(amely.name);

    }

}
