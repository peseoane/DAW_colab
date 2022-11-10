package piedrapapelytijeras;

import java.util.Scanner;

public class Player {

    // Atributos
    // @amelych he eliminado el que sea estático porque no tiene sentido, las
    // puntuaciones y nombre tendrán sentido cuando cree el objeto.
    public String name;
    public int playerAction;
    public int scorePlayer;
    // public byte scorePc;
    // ^ Esto debería ir en NPC

    // Constructor

    public Player(String name, int playerAction, int scorePlayer, int scorePc) {
        this.name = name;
        this.playerAction = playerAction;
        this.scorePlayer = scorePlayer;
        // this.scorePc = scorePc;
    }

    // Métodos

    public int playerChoice() {
        Scanner input = new Scanner(System.in);
        // Limpieza del buffer
        input.next();
        playerAction = input.nextByte();
        input.close();
        return playerAction;
    }

}
