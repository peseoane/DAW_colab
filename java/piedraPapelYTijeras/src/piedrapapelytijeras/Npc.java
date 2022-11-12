package piedrapapelytijeras;

public class Npc extends CommonRules {

    private boolean godMode;

    /**
     * En este caso, el constructor del NPC es automático con el nombre PC, es importante inicializar a cero
     * y falso los campos, porque cuando compruebe sus estadísticas respecto a las del jugador, dará error
     * si son nulas.
     */
    public Npc() {
        this.name = "PC";
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0; // Es importante iniciarlos en cero, la primera partida si no, al sumarle y autoincremento no dejará hacerlo.
        this.godMode = false; // Lo mismo aquí, si no hay ganador, el godMode quedaría null por defecto, lo dejamos en falso como inicio
    }


    public boolean isGodMode() {
        return godMode;
    }

    /**
     * Nos genera de manera aleatoria si hay modo Dios o no, dependerá posteriormente de la implementación
     * aplicarlo o no, usualmente solamente si va perdiendo.
     *
     * @return boolean godMode
     */
    public boolean createGodMode() {
        this.godMode = new java.util.Random().nextBoolean();
        return this.godMode;
    }

    /**
     * El modo Dios solo se puede activar, si de modo aleatorio así se ha decidido y además el NPC
     * va perdiendo, es decir, no siempre que pierda nos ganará.
     * El Switch lee la jugada del jugador, y al ser fácil (piedra siempre gana a tijeras por ejemplo)
     * nos devuelve la jugada que será invencible.
     * Por eso es importante respetar el orden de invocaciones.
     * En caso de NO tener el booleano activado ni perder, simplemente generará una jugada del [0-2]
     *
     * @param player recibe al objeto jugador con la jugada "action" YA calculada.
     */
    public void calculateAction(Player player) {
        if (createGodMode() && player.getLocalScore() > getLocalScore()) {
            switch (player.getAction()) {
                case 0 -> setAction(1);
                case 1 -> setAction(2);
                case 2 -> setAction(0);
            }
        } else {
            setAction(new java.util.Random().nextInt(3));
            // Pequeño bug... al generar en el primer bucle el modo dios, puede decir que está activado sin estarlo.
            this.godMode = false;
        }
    }
}
