package piedrapapelytijeras;

public class Player extends CommonRules {

    /**
     * Esta clase nos proporciona la estructura básica para el jugador.
     * - name: guarda una cadena con el nombre del jugador, pero esta se inicializará mediante
     * un método que comprobará si es Marta, o no, está ofuscado.
     */
    public Player() {
        this.name = playerName();
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0;
    }


    // ¡Está ofuscado apropósito por la broma! Obviamente, no hacemos las cosas así.
    public String playerName() {

        System.out.println("Introduce tu nombre: ");
        String name = input.nextLine();
        if (name.equalsIgnoreCase(TerminalAux.EASTER_EGG0)) {
            System.out.println(TerminalAux.EASTER_EGG1);
        }
        return name;
    }

    public void playerChoice() {

        // Solo podemos aceptar 0 1 o 2
        boolean loopKeyboardError;
        int numAction;
        String election;

        System.out.println(TerminalAux.DIALOG);

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
                    // ¿Qué no? Se lo decimos amablemente al usuario...
                    // @amelych fíjate que excepciones puedes definir una o coger una que se ajuste
                    // al error que tienes y te ahorras clear la clase... el mensaje lo puedes pasar
                    // entre los corchetes, pero prefiero hacerlo debajo cuando las capture
                    throw new ArrayIndexOutOfBoundsException();
                }

            } // aquí nada, por cada tipo de error, creo que sólo hay dos posibles, NO ES
            // BUENA IDEA CAPTURAR todas las cosas, luego se te cuelan errores, vete
            // acotando por tipo de error en medida de lo posible.
            catch (NumberFormatException e) {
                System.err.println("ERROR: Please, select a valid choice.");
                System.err.println(TerminalAux.DIALOG);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("0,1 & 2 are the valid options");
                System.err.println(TerminalAux.DIALOG);
            }
        }
    }
}
