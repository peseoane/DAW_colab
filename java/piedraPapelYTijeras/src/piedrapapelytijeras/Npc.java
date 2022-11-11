package piedrapapelytijeras;

public class Npc {

    private String name;
    private int action;
    public int localScore;
    private int globalScore;
    private boolean godMode;

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

    public void addGlobalScore(){
        this.globalScore += 1;
    }

    public void setGlobalScore(int globalScore) {
        this.globalScore = globalScore;
    }

    public boolean isGodMode() {
        return godMode;
    }
    
    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }

    public boolean createGodMode(){
        this.godMode = new java.util.Random().nextBoolean();
        return this.godMode;
    }

    public void addWin() {
        localScore += 1;
    };

    /**
     * 
     */
    public Npc() {
        this.name = "PC";
        this.action = 0;
        this.localScore = 0;
        this.globalScore = 0;
        this.godMode = false;
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
