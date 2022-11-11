package piedrapapelytijeras;

import java.util.Scanner;

public class Player {

    // Atributos
    // @amelych he eliminado el que sea estático porque no tiene sentido, las
    // puntuaciones y nombre tendrán sentido cuando cree el objeto.
    public String name;
    public int action;
    public int localScore;
    public int globalScore;
    // public byte scorePc;
    // ^ Esto debería ir en NPC

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getLocalScore() {
        return localScore;
    }

    public void setLocalScore(int localScore) {
        this.localScore = localScore;
    }

    public int getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(int globalScore) {
        this.globalScore = globalScore;
    }

    public void addGlobalScore(){
        this.globalScore += 1;
    }

    public void addWin() {
        localScore++;
    }

    static Scanner input = new Scanner(System.in);

    // Constructor

    public Player() {
        this.name = null;
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0;
        // this.scorePc = scorePc;
    }

    // Métodos

    public void playerName() {
        
        System.out.println("Introduce tu nombre: ");
        name = input.nextLine();
    }

    public void playerChoice() {
        System.out.println(Colour.DIALOG);
        action = input.nextInt();
    }

}
