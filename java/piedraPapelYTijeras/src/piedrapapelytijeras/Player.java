package piedrapapelytijeras;

import java.util.Scanner;

public class Player {

    static final Scanner input = new Scanner(System.in);
    // Atributos

    private String name;
    private int action;
    // @amelych he eliminado el que sea estático porque no tiene sentido, las
    // puntuaciones y nombre tendrán sentido cuando cree el objeto, no es algo
    // inherente a la clase, si no al objeto en concreto.
    private int localScore;
    // public byte scorePc;
    // ^ Esto debería ir en NPC
    private int globalScore;
    // Y no vamos a usar bytes, porque no sé porque a Java muchos de los métodos
    // incorporados no le hacen gracia así que todo con Ints que esto no es un z80
    // spectrum con 16KB de RAM tampoco hace falta...


    public Player() {
        this.name = null; // ¿Esto es correcto? ¿Debería poner ""?
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0;
        // this.scorePc = scorePc;
    }

    public String getName() {
        return name;
    }

    // InteliJ es bastante bueno eliminando cosas no usadas
    // --Commented out by Inspection START (11/11/2022 19:15):
    // public void setName(String name) {
    // this.name = name;
    // }
    // --Commented out by Inspection STOP (11/11/2022 19:15)

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

    // --Commented out by Inspection START (11/11/2022 19:15):
    // public void setGlobalScore(int globalScore) {
    // this.globalScore = globalScore;
    // }
    // --Commented out by Inspection STOP (11/11/2022 19:15)

    public void addGlobalScore() {
        this.globalScore++;
    }

    public void addWin() {
        this.localScore++;
    }

    // Está ofuscado apropósito por la broma! Obviamente no hacemos las cosas así.
    public void playerName() {

        System.out.println("Introduce tu nombre: ");
        name = input.nextLine();
            if (name.equalsIgnoreCase(Colour.EASTER_EGG0)){
                System.out.println(Colour.EASTER_EGG1);
            }
    }

    /**
     * Le pide al usuario un número del 0,1,2 (piedra, papel o tijeras),
     * comprueba que sea un dato válido y no sale de ahí hasta hacerlo
     * correctamente, actualiza el objeto directamente, no hay retornos.
     */
    public void playerChoice() {

        // Sólo podemos aceptar 0 1 o 2
        boolean loopKeyboardError;
        int numAction;
        String election;

        System.out.println(Colour.DIALOG);

        // bucle hasta que esté bien metido el dato
        loopKeyboardError = true;
        while (loopKeyboardError) {
            // lo leo como cadena
            election = input.nextLine();

            try {
                // si esto no revienta la JVM...
                numAction = Integer.parseInt(election);
                // siguiente posible excepción, que esté fuera de rango
                if (numAction >= 0 && numAction <= 3) {
                    setAction(numAction);
                    loopKeyboardError = false;
                } else {
                    // Que no? Se lo decimos amablemente al usuario...
                    // @amelych fíjate que excepciones puedes definir una o coger una que se ajuste
                    // al error que tienes y te ahorras clear la clase... el mensaje lo puedes pasar
                    // entre los corchetes pero prefiero hacerlo debajo cuando las capture
                    throw new ArrayIndexOutOfBoundsException();
                }

            } // aquí nada, por cada tipo de error, creo que sólo hay dos posibles, NO ES
            // BUENA IDEA CAPTURAR todas las cosas, luego se te cuelan errores, vete
            // acotando por tipo de error en medida de lo posible.
            catch (NumberFormatException e) {
                System.err.println("ERROR: Please, select a valid choice.");
                System.err.println(Colour.DIALOG);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("0,1 & 2 are the valid options");
                System.err.println(Colour.DIALOG);
            }
        }
    }
}
