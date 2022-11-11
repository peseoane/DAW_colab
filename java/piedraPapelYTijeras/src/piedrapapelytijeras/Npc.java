package piedrapapelytijeras;

public class Npc {

    private final String name;
    /*
     * Vamos a intentar hacer privado todo lo posible, y trabajar con los métodos
     * que parece que es la guía de prácticas y estilo pedida, aunque no hay muchas
     * comprobaciones en los métodos, el programa no da a lugar a romper las cosas
     * (Creo yo...)
     */
    private int localScore;
    private int action;
    private int globalScore;
    private boolean godMode;

    /**
     * Al PC le doy nombre fijo porque no tiene sentido, esto se hizo pensando en
     * una superclase común a NPC y player pero Marta ha dicho que mejor interpretar
     * el UML como una relación de Player NPC y Game, y no una de Game <-> con
     * Players->NPC&&Player así que...
     * <p>
     * ..algún día se refactorizará esto?
     */

    public Npc() {
        this.name = "PC";
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0; // Es importante iniciarlos en cero, la primera partida si no, al sumarle el
        // autoincremento no dejará hacerlo!
        this.godMode = false; // Lo mismo aquí, si no hay ganador, el godMode quedaría null por defecto, lo
        // dejamos en falso como inicio
    }

    public String getName() {
        return name;
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

// --Commented out by Inspection START (11/11/2022 20:54):
//    public void setGlobalScore(int globalScore) {
//        this.globalScore = globalScore;
//    }
// --Commented out by Inspection STOP (11/11/2022 20:54)

    public void addGlobalScore() {
        this.globalScore += 1;
    }

    public boolean isGodMode() {
        return godMode;
    }

// --Commented out by Inspection START (11/11/2022 20:54):
//    public void setGodMode(boolean godMode) {
//        this.godMode = godMode;
//    }
// --Commented out by Inspection STOP (11/11/2022 20:54)

    public boolean createGodMode() {
        this.godMode = new java.util.Random().nextBoolean();
        return this.godMode;
    }

    // Al parecer si que funcionan los autoincrementos
    public void addWin() {
        this.localScore++;
    }

    public void calculateAction(Player player) {
        if (createGodMode() && getLocalScore() > getLocalScore()) {
            switch (player.getAction()) {
                case 0, 2 -> setAction(1);
                case 1 -> setAction(2);
            }
        } else {
            setAction(new java.util.Random().nextInt(3));
        }
    }
}
