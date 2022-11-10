package piedrapapelytijeras;

public class Pc {
    // Atributos
    private boolean godMode;
    private byte pcAction;

    // Constructor
    public Pc(boolean godMode) {
        this.godMode = godMode;
        this.pcAction = (byte) (new java.util.Random().nextInt(3));
    }

    // Méetodos

    public int pcChoice() {
        pcAction = (byte) (new java.util.Random().nextInt(3));
        return pcAction;
    }

    private boolean cheatEnable() {
        
    }

}
