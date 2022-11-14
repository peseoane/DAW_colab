package piedrapapelytijeras;

import java.util.Scanner;

public class CommonRules {
    /**
     * Esta clase va a ser llamada varias veces por miembros, así que la hacemos estática, varios métodos como
     * pedir jugada o pedir nombre harán uso de ella.
     */
    protected static final Scanner input = new Scanner(System.in, TerminalAux.ENCODING);
    /**
     * name: guarda una cadena con el nombre del jugador.
     */
    protected String name;
    /*
     * action: guarda un entero con la opción:
     *      - 0: piedra
     *      - 1: papel
     *      - 2: tijeras
     */
    protected int action;
    /**
     * localScore: en un rango de [0-3] almacena en la partida nuestras victorias, será reiniciado en cada partida.
     */
    protected int localScore;
    /**
     * globalScore: guarda el número de victorias totales.
     */
    protected int globalScore;

    protected String getName() {
        return name;
    }

    protected int getAction() {
        return action;
    }

    /**
     * Guarda la acción deseada por el jugador/pc siendo:
     * 0: piedra.
     * 1: papel.
     * 2: tijeras.
     * No comprueba errores, eso se hace al pedir los datos.
     *
     * @param action debe recibir el entero con la jugada ya procesada, si el ordenador hace trampa, la calculará antes
     *               de pasarla por aquí
     */
    protected void setAction(int action) {
        this.action = action;
    }

    protected int getLocalScore() {
        return localScore;
    }

    protected void setLocalScore(int localScore) {
        this.localScore = localScore;
    }

    protected int getGlobalScore() {
        return globalScore;
    }

    protected void addGlobalScore() {
        this.globalScore++;
    }

    protected void addWin() {
        this.localScore++;
    }
}